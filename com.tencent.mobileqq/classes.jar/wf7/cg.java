package wf7;

import android.text.TextUtils;

public class cg
{
  static cg gZ;
  
  private String J(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "wifi_user_phone";
    case 3: 
      return "phone_num_from_pimsecure";
    case 4: 
      return "phone_num_from_push";
    case 2: 
      return "phone_num_from_system";
    }
    return "phone_num_from_temp_input";
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
    if (paramInt == 5) {}
    String str;
    do
    {
      do
      {
        return null;
        str = J(paramInt);
      } while (TextUtils.isEmpty(str));
      str = ch.aP().getString(str, "");
    } while (TextUtils.isEmpty(str));
    return new bv(str, paramInt);
  }
  
  public boolean aM()
  {
    return ch.aP().getBoolean("user_agree_cooper_phone_infi", false);
  }
  
  public bv aN()
  {
    Object localObject = I(1);
    if (localObject != null) {}
    bv localbv;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject;
            localbv = I(3);
            localObject = localbv;
          } while (localbv != null);
          localbv = I(2);
          localObject = localbv;
        } while (localbv != null);
        localbv = I(4);
        localObject = localbv;
      } while (localbv != null);
      localbv = I(5);
      localObject = localbv;
    } while (localbv != null);
    return null;
  }
  
  public boolean aO()
  {
    boolean bool = true;
    bv localbv = aN();
    if (localbv != null)
    {
      if (localbv.gu != 1) {
        bool = aL().aM();
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cg
 * JD-Core Version:    0.7.0.1
 */