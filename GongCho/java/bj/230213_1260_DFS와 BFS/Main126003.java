package baekjun.DFSBFS;

//bfs�� bfs��, 
//��� ��������Ʈ�� �����ϴ���, ������ķ� �����ϴ��Ŀ� ���� �ð����⵵�� �޶����µ�,
//��������Ʈ�� ������������ �ð����⵵�� o(v+e)
//������ķ� ������������ �ð����⵵�� o(v^2)�̴�.
//���� ���������� ��������Ʈ��, ��������̵� ��� Ǯ �� ������,
//������ ������ �ִ��� õ, ������ ������ �ִ��� ���̶�� �Ҷ�
//��������Ʈ�� �ð����⵵�� �� �����Ƿ�(ȿ�����̹Ƿ�), ��������Ʈ�� �����Ѵ�.
//��������Ʈ�� �Ϲ������� ArrayList<ArrayList<Integer>>����� ����ؿ�����,
//�̹����� ArrayList<Integer>[]�� �����غ��ڴ�.

import java.io.*;
import java.util.*;

public class Main126003 {
	
	static int n,m,v;
	static StringTokenizer st;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(v);
		sb.append('\n');
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		
		for(int i=0; i<graph[start].size(); i++) {
			if(!visited[graph[start].get(i)]) {
				dfs(graph[start].get(i));
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(' ');
			
			for(int i=0; i<graph[x].size(); i++) {
				if(!visited[graph[x].get(i)]) {
					visited[graph[x].get(i)] = true;
					q.offer(graph[x].get(i));
				}
			}
		}
	}

}
