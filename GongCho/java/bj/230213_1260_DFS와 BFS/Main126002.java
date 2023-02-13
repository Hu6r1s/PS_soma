package baekjun.DFSBFS;

//bfs, dfs��� ������ķ� ������������ �ð����⵵ : o(n^2)
//bfs, dfs��� ��������Ʈ�� ������������ �ð����⵵ : o(n+e)

//n�� �ִ��� õ�̹Ƿ�, o(n^2), o(n+e) ��� 2�ʳ��� Ǯ �� �����Ƿ�, ������ ��ġ�� ����.
//��������Ʈ�� ���ϴ� ���� ��·�� �� ȿ�����̴ϱ�, ��������Ʈ�� ������ ����.

//������ȣ�� �����ͺ��� �湮������ϱ⶧����, ��������Ʈ�� ����������ϴµ�,
//ArrayList<ArrayList<Integer>>���� ����ArrayList<Integer>�� �������ֱ�����
//������ ������ȣ���� �����Ͽ� Collections.sort(graph.get(i))�� �������ش�.
import java.io.*;
import java.util.*;

public class Main126002 {
	
	static int n,m,v;
	static StringTokenizer st;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		
		//System.out.println(graph);
		
		dfs(v);
		sb.append('\n');
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(' ');
		
		for(int i=0; i<graph.get(start).size(); i++) {
			if(!visited[graph.get(start).get(i)]) {
				dfs(graph.get(start).get(i));
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node).append(' ');
			
			for(int i=0; i<graph.get(node).size(); i++) {
				if(!visited[graph.get(node).get(i)]) {
					visited[graph.get(node).get(i)] = true;
					q.offer(graph.get(node).get(i));
				}
			}
		}
	}

}
