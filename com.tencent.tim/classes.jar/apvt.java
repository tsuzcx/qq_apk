class apvt
  extends apvi
{
  apvt(apvs paramapvs, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        break label22;
      }
    }
    label22:
    do
    {
      do
      {
        return;
        paramObject = paramObject[0];
      } while (!(paramObject instanceof boolean[]));
      paramObject = (boolean[])paramObject;
    } while ((paramArrayOfb == null) || (paramArrayOfb.length <= 0) || (paramObject.length != 3));
    if ((paramArrayOfb.length < 0) && (paramObject[0] != 0))
    {
      paramArrayOfb[0].dOf = 0;
      paramArrayOfb[0].dOe = 0;
    }
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (i < paramArrayOfb.length)
      {
        paramInt = i;
        if (paramObject[1] != 0)
        {
          paramArrayOfb[i].dOf = 1;
          paramArrayOfb[i].dOe = 1;
          paramInt = i + 1;
        }
      }
      i = paramInt;
      if (paramInt < paramArrayOfb.length)
      {
        i = paramInt;
        if (paramObject[2] != 0)
        {
          paramArrayOfb[paramInt].dOf = 2;
          paramArrayOfb[paramInt].dOe = 0;
          i = paramInt + 1;
        }
      }
      while (i < paramArrayOfb.length)
      {
        paramArrayOfb[i].dOf = -1;
        paramArrayOfb[i].dOe = -1;
        i += 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvt
 * JD-Core Version:    0.7.0.1
 */