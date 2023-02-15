package baekjun.BackTrack;

//�ð����⵵ : m�� n�� �ִ��� 7�̱⶧����, 
//m, n�� ��� 7�ϰ��, 
//7������ �ڿ��� �߿��� 7���� ��� �� ���� -> �̶�, ������ ����ؾ��ϱ⶧����,
//�־��� ���� 7 * 7 * ... -> 7�� 7�������� �ð����⵵�� ������ �� ����.

import java.io.*;
import java.util.*;

public class Main1565104 {
	
	static StringTokenizer st;
	static int n,m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
		pro(0);
		System.out.println(sb);
	}
	
	static void pro(int idx) {
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int cand = 1; cand <= n; cand++) {
			selected[idx] = cand;
			pro(idx + 1);
		}
	}

}
