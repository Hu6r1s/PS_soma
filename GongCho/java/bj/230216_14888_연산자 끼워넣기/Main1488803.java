package baekjun.BackTrack;

//�����ڸ� �߰��� ���Ǵ� ���� ��� �� ���� ����� -10��� 10������� ���̹Ƿ�, �����ڸ� �����ѵ� ����� ���� int����(-21��~21��)�� �����.
//���� ������ 11���϶�, �����ڴ� 10�� �����ϰ�, �� 10���� �����ϴ� ���� �����Ƿ�, 10!�̶�� ������.(�ð����⵵) -> ����
//��, �̰��� ������ ����Ͽ� �ߺ��� ������� �ʴ� ��쿡 �ش�

//�����ڸ� �̸� �����ϴ°��
import java.io.*;
import java.util.*;

public class Main1488803 {
	
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] a,operator,selected;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		operator = new int[4];
		selected = new int[n-1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		pro(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void pro(int idx) {
		if(idx == n-1) {
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		for(int cand=0; cand<4; cand++) {
			if(operator[cand] != 0) {
				selected[idx] = cand;
				operator[cand]--;
				pro(idx + 1);
				operator[cand]++;
			}
		}
	}
	
	static int calculator() {
		int value = a[0];
		for(int i=1; i<=n-1; i++) {
			if(selected[i-1] == 0) {
				value = value + a[i];
			} else if(selected[i-1] == 1) {
				value = value - a[i];
			} else if(selected[i-1] == 2) {
				value = value * a[i];
			} else {
				value = value / a[i];
			}
		}
		return value;
	}

}
