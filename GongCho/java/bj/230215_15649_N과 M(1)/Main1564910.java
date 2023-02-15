package baekjun.BackTrack;

import java.io.*;
import java.util.*;

//�ð����⵵ : n�� m�� �ִ��� 8�̹Ƿ�, 8! = �� 4�������̹Ƿ�,
//��� ����Ǽ��� 4�������̰�, ��� ����� ���� ���ϴ� �� ��ü�� �ð����⵵�̴�, 
//���� �� �ð����⵵�� 4�������� ������ �� ����.

public class Main1564910 {
	
	static int n,m;
	static StringTokenizer st;
	static int[] selected, isUsed;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
		isUsed = new int[n+1];
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
		
		for(int cand = 1; cand <= n; cand++) {
			if(isUsed[cand] == 0) {
				selected[idx] = cand;
				isUsed[cand] = 1;
				pro(idx + 1);
				isUsed[cand] = 0;
			}
		}
	}

}
