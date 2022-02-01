package wf7;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;

class er$2
  implements dq
{
  er$2(er paramer) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if ((paramInt3 != 0) || (paramInt4 != 0) || (paramJceStruct == null)) {}
    do
    {
      return;
      paramJceStruct = ((ac)paramJceStruct).co;
      if (!TextUtils.isEmpty(paramJceStruct))
      {
        er.a(this.pi, paramJceStruct);
        er.a(this.pi).cT().c(paramJceStruct, false);
        er.a(this.pi).cT().d(paramJceStruct, false);
        return;
      }
    } while (!ea.ct());
    throw new RuntimeException("vid is empty: " + paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.er.2
 * JD-Core Version:    0.7.0.1
 */