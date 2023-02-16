package baekjun.BackTrack;

import java.io.*;
import java.util.*;
//�μ��� ���ϴ� �ִ�ġ�� 2�鸸�� -2�鸸 ������ ���̹Ƿ� int�� ��Ƶ� ��.
//n=20�϶��� ��� ����� ���� �� �ð����⵵���ٵ�, ��� ����� ���� ��� ��������?

public class Main118203 {
	
	static StringTokenizer st;
	static int n,s,cnt;
	static int[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		pro(0,0);
		if(s == 0) {
			System.out.println(cnt - 1);
		} else {
			System.out.println(cnt);
		}
	}
	
	static void pro(int idx, int sum) {
		if(idx == n) {
			if(sum == s) {
				cnt += 1;
			}
			return;
		}
		
		//�����ϴ°��
		pro(idx + 1,a[idx] + sum);
		//�������� �ʴ� ���
		pro(idx + 1, sum);
	}

}
