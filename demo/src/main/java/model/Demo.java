package model;

import java.util.ArrayList;

public class Demo {
	private float x1,x2;
	private float x;
	private Boolean vn;
	private Boolean vsn;
	private Boolean ptb2;
	public void phuongtrinhbac2(float a, float b, float c)
	{
		float delta = b*b-4*a*c;
		if(a==0)
		{
			this.ptb2 = false;
			if(b == 0 )
			{
				if(c == 0)
				{
					this.vsn= true;
				}else {
					this.vsn = true;
				}
			}else {
				if(c == 0)
				{
					this.x= 0;
				}else {
					this.x = -c/b;
				}
			}
			
			
		}else {
			if(delta< 0)
			{
				this.vn = true;
			}else {
				if(delta == 0)
				{
					this.x = -b/(2*a);
				}else {
					this.x1 = (float) ((-b + Math.sqrt(delta))/(2*a));
					this.x2=  (float) ((-b - Math.sqrt(delta))/(2*a));
				}
			}
		}
		
	}
}
