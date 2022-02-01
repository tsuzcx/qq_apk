import com.tencent.mobileqq.activity.recent.RecentBaseData;

class aakc
  extends auve
{
  aakc(aakb paramaakb, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {
      return;
    }
    if ((paramObject instanceof RecentBaseData)) {}
    label151:
    label417:
    label443:
    for (int k = ((RecentBaseData)paramObject).mMenuFlag;; k = 0)
    {
      if (((paramObject instanceof RecentBaseData)) && ((((RecentBaseData)paramObject).ng() == 1008) || (((RecentBaseData)paramObject).ng() == 7220)))
      {
        if ((paramArrayOfb.length >= 0) || (!aakp.iO(((RecentBaseData)paramObject).qx())) || (!aaku.a().WB()) || (aaku.a().ew(((RecentBaseData)paramObject).qx()))) {
          break label483;
        }
        paramArrayOfb[0].dOf = 6;
        paramArrayOfb[0].dOe = 1;
      }
      label213:
      label477:
      label483:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfb.length)
        {
          paramArrayOfb[i].dOf = 0;
          paramArrayOfb[i].dOe = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfb.length)
        {
          paramArrayOfb[paramInt].dOf = -1;
          paramArrayOfb[paramInt].dOe = -1;
          paramInt += 1;
          continue;
          if (paramArrayOfb.length >= 0) {
            break label477;
          }
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label417;
          }
          paramArrayOfb[0].dOf = 2;
          paramArrayOfb[0].dOe = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfb.length)
          {
            paramInt = i;
            if ((paramObject instanceof RecentBaseData))
            {
              paramInt = i;
              if (((RecentBaseData)paramObject).Gq())
              {
                j = 0xF0000 & k;
                if (j != 65536) {
                  break label443;
                }
                paramArrayOfb[i].dOf = 4;
                paramArrayOfb[i].dOe = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfb.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfb[paramInt].dOf = 9;
                paramArrayOfb[paramInt].dOe = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfb.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfb[i].dOf = 0;
                paramArrayOfb[i].dOe = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfb.length) {
              break label151;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label151;
            }
            paramArrayOfb[j].dOf = 6;
            paramArrayOfb[j].dOe = 1;
            paramInt = j + 1;
            break label151;
            break;
            if (paramInt != 16) {
              break label477;
            }
            paramArrayOfb[0].dOf = 3;
            paramArrayOfb[0].dOe = 0;
            i = 1;
            break label213;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfb[i].dOf = 5;
              paramArrayOfb[i].dOe = 1;
              paramInt = i + 1;
            }
          }
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakc
 * JD-Core Version:    0.7.0.1
 */