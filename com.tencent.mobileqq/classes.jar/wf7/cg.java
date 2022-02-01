package wf7;

import android.text.TextUtils;

public class cg
{
  static cg gZ;
  
  private String J(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return "phone_num_from_temp_input";
          }
          return "phone_num_from_push";
        }
        return "phone_num_from_pimsecure";
      }
      return "phone_num_from_system";
    }
    return "wifi_user_phone";
  }
  
  public static final cg aL()
  {
    try
    {
      if (gZ == null) {
        gZ = new cg();
      }
      cg localcg = gZ;
      return localcg;
    }
    finally {}
  }
  
  public bv I(int paramInt)
  {
    Object localObject2 = null;
    if (paramInt == 5) {
      return null;
    }
    String str = J(paramInt);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      str = ch.aP().getString(str, "");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str)) {
        localObject1 = new bv(str, paramInt);
      }
    }
    return localObject1;
  }
  
  public boolean aM()
  {
    return ch.aP().getBoolean("user_agree_cooper_phone_infi", false);
  }
  
  public bv aN()
  {
    bv localbv = I(1);
    if (localbv != null) {
      return localbv;
    }
    localbv = I(3);
    if (localbv != null) {
      return localbv;
    }
    localbv = I(2);
    if (localbv != null) {
      return localbv;
    }
    localbv = I(4);
    if (localbv != null) {
      return localbv;
    }
    localbv = I(5);
    if (localbv != null) {
      return localbv;
    }
    return null;
  }
  
  public boolean aO()
  {
    bv localbv = aN();
    if (localbv != null)
    {
      if (localbv.gu != 1) {
        return aL().aM();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cg
 * JD-Core Version:    0.7.0.1
 */