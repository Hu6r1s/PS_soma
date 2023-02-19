package ThisCodingTest.Simulation;

import java.io.*;
import java.util.*;

public class QuestionP11802 {
	
	static int n,m,direction,a,b;
	static StringTokenizer st;
	//�湮�� ��ġ�� �����ϱ� ���� ���� �����Ͽ� 0���� �ʱ�ȭ
	static int[][] visited = new int[50][50];
	static int[][] graph = new int[50][50];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void turn_left() {
		direction -= 1;
		if(direction == -1) {
			direction = 3;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		visited[a][b] = 1;
		
		//�׷��� ���� �Է¹ޱ�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
	}
	
	static void pro() {
		int cnt = 1;
		int turn_time = 0;
		while(true) {
			//�������� ȸ��
			turn_left();
			int nx = a + dx[direction];
			int ny = b + dy[direction];
			//ȸ���� ���� ���鿡 ������ ���� �����ϴ� ��� �̵�
			if(visited[nx][ny] == 0 && graph[nx][ny] == 0) {
				visited[nx][ny] = 1;
				a = nx;
				b = ny;
				cnt += 1;
				turn_time = 0;
				continue;
			}
			//ȸ���� ���� ���鿡 ������ ���� ĭ�� ���ų� �ٴ��ΰ��
			else turn_time += 1;
			
			//�� ���� ��� �� �� ���� ���
			if(turn_time == 4) {
				nx = a - dx[direction];
				ny = b - dy[direction];
				//�ڷ� �� �� �ִٸ� �̵��ϱ�
				if(graph[nx][ny] == 0) {
					a = nx;
					b = ny;
					turn_time = 0;
				} 
				//�ڰ� �ٴٷ� �����ִ� ���
				else break;
			}
		}
		System.out.println(cnt);
	}

}
