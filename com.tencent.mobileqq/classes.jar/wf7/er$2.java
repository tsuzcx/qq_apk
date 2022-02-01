package wf7;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;

class er$2
  implements dq
{
  er$2(er paramer) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if ((paramInt3 == 0) && (paramInt4 == 0))
    {
      if (paramJceStruct == null) {
        return;
      }
      paramJceStruct = ((ac)paramJceStruct).co;
      if (!TextUtils.isEmpty(paramJceStruct))
      {
        er.a(this.pi, paramJceStruct);
        er.a(this.pi).cT().c(paramJceStruct, false);
        er.a(this.pi).cT().d(paramJceStruct, false);
        return;
      }
      if (!ea.ct()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vid is empty: ");
      localStringBuilder.append(paramJceStruct);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.er.2
 * JD-Core Version:    0.7.0.1
 */