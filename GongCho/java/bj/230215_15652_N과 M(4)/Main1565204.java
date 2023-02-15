package baekjun.BackTrack;

//n�� m�� �ִ��� 8�̹Ƿ�,
//������ �����ؾ��ϴ� ��� ���� �뷫 8�� 8����(����, �񳻸������� ���� �����������)
//8�� 8������ 1�ﺸ�ٴ� ���� ���̹Ƿ�, 1�ʾȿ� ����� Ǯ �� ����.

import java.io.*;
import java.util.*;

public class Main1565204 {
	
	static StringTokenizer st;
	static int n,m;
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
			start = selected[idx - 1];
		}
		
		for(int cand = start; cand <= n; cand++) {
			selected[idx] = cand;
			pro(idx + 1);
		}
	}

}
