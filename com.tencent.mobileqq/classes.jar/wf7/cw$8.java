package wf7;

import com.qq.taf.jce.JceStruct;

class cw$8
  implements ay
{
  cw$8(cw paramcw) {}
  
  public az<Long, Integer, JceStruct> a(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct)
  {
    az localaz = null;
    if (paramInt2 != 13713) {
      return null;
    }
    if (paramJceStruct != null)
    {
      if (!(paramJceStruct instanceof g)) {
        return null;
      }
      paramJceStruct = (g)paramJceStruct;
      cw.a(this.iJ, paramJceStruct);
      paramJceStruct = new String(df.a(paramJceStruct));
      ch.aP().putString("p_s_c", paramJceStruct);
      paramJceStruct = new b();
      paramJceStruct.n = 0;
      localaz = new az(Long.valueOf(paramLong), Integer.valueOf(13713), paramJceStruct);
    }
    return localaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cw.8
 * JD-Core Version:    0.7.0.1
 */