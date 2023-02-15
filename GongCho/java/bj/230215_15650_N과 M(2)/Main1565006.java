package baekjun.BackTrack;

import java.io.*;
import java.util.*;

//�ð����⵵ : n�� m�� �ִ��� 8�̰�, 8^8���ٴ� ���� ���̹Ƿ�, 1�ʾȿ� ����� ������ ��ġ�� ����.

public class Main1565006 {
	
	static int n,m;
	static StringTokenizer st;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		int start;
		if(idx == 0) {
			start = 1;
		} else {
			start = selected[idx - 1] + 1;
		}
		
		for(int cand = start; cand <= n; cand++) {
			selected[idx] = cand;
			pro(idx + 1);
		}
	}

}
