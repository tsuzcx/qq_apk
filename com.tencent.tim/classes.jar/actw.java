import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class actw
  extends acuk
{
  public actw(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean aci()
  {
    if (QLog.isColorLevel()) {
      ajrk.m("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent(this.context, NearbyActivity.class);
    localIntent.putExtra("TAB_TYPE", 1);
    String str2;
    if (this.attrs.containsKey("src_type")) {
      str2 = (String)this.attrs.get("src_type");
    }
    for (;;)
    {
      String str4;
      label100:
      String str5;
      label126:
      String str1;
      if (this.attrs.containsKey("web_url"))
      {
        str4 = (String)this.attrs.get("web_url");
        if (!this.attrs.containsKey("from")) {
          break label706;
        }
        str5 = (String)this.attrs.get("from");
        if (!this.attrs.containsKey("from_type")) {
          break label713;
        }
        str1 = (String)this.attrs.get("from_type");
        label152:
        localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
        localIntent.putExtra("fromWhere", str2);
        localIntent.putExtra("webUrl", str4);
        localIntent.putExtra("fromType", str1);
        localIntent.putExtra("FROM_WHERE", 1);
        if (!this.attrs.containsKey("neighbor_list_source")) {}
      }
      try
      {
        i = Integer.parseInt((String)this.attrs.get("neighbor_list_source"));
        localIntent.putExtra("neighbor_list_source", i);
        if ("10002".equals(str5))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if (this.attrs.containsKey("filter"))
        {
          str2 = (String)this.attrs.get("filter");
          if ("1".equals(str2))
          {
            if (!this.attrs.containsKey("filter_gender")) {
              break label739;
            }
            str4 = (String)this.attrs.get("filter_gender");
            if (!this.attrs.containsKey("filter_time")) {
              break label746;
            }
            str5 = (String)this.attrs.get("filter_time");
            if (!this.attrs.containsKey("filter_age")) {
              break label753;
            }
            str6 = (String)this.attrs.get("filter_age");
            if (!this.attrs.containsKey("filter_xingzuo")) {
              break label760;
            }
            str7 = (String)this.attrs.get("filter_xingzuo");
            if (!this.attrs.containsKey("filter_interest")) {
              break label767;
            }
            str8 = (String)this.attrs.get("filter_interest");
            if (!this.attrs.containsKey("filter_career")) {
              break label774;
            }
            str9 = (String)this.attrs.get("filter_career");
            if (!this.attrs.containsKey("filter_location")) {
              break label781;
            }
            str10 = (String)this.attrs.get("filter_location");
          }
        }
      }
      catch (Exception localException6)
      {
        try
        {
          i = Integer.valueOf(str4).intValue();
        }
        catch (Exception localException6)
        {
          try
          {
            j = Integer.valueOf(str5).intValue();
          }
          catch (Exception localException6)
          {
            try
            {
              k = Integer.valueOf(str6).intValue();
            }
            catch (Exception localException6)
            {
              try
              {
                m = Integer.valueOf(str7).intValue();
              }
              catch (Exception localException6)
              {
                try
                {
                  n = Integer.valueOf(str9).intValue();
                }
                catch (Exception localException6)
                {
                  try
                  {
                    for (;;)
                    {
                      i1 = Integer.valueOf(str8).intValue();
                      localIntent.putExtra("filter", str2);
                      localIntent.putExtra("filterGender", i);
                      localIntent.putExtra("filter_time", j);
                      localIntent.putExtra("filter_age", k);
                      localIntent.putExtra("filter_xingzuo", m);
                      localIntent.putExtra("filter_interest", i1);
                      localIntent.putExtra("filter_career", n);
                      localIntent.putExtra("filter_location", str10);
                      localIntent.addFlags(67108864);
                      if (!(this.context instanceof Activity)) {
                        localIntent.addFlags(268435456);
                      }
                      this.context.startActivity(localIntent);
                      if ("100".equals(str1)) {
                        anot.a(this.app, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
                      }
                      return true;
                      str2 = "";
                      break;
                      str4 = "";
                      break label100;
                      label706:
                      str5 = "";
                      break label126;
                      label713:
                      str1 = "";
                      break label152;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label739:
                      str4 = "";
                      continue;
                      label746:
                      str5 = "";
                      continue;
                      label753:
                      String str6 = "";
                      continue;
                      label760:
                      String str7 = "";
                      continue;
                      label767:
                      String str8 = "";
                      continue;
                      label774:
                      String str9 = "";
                      continue;
                      label781:
                      String str10 = "";
                      continue;
                      localException2 = localException2;
                      i = 0;
                      continue;
                      localException3 = localException3;
                      int j = 3;
                      continue;
                      localException4 = localException4;
                      int k = 0;
                      continue;
                      localException5 = localException5;
                      int m = 0;
                      continue;
                      localException6 = localException6;
                      int n = 0;
                    }
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      int i1 = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean ace()
  {
    try
    {
      boolean bool = aci();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("GotoNearbyAction", 1, "doAction error: " + localException.getMessage());
      Ge("GotoNearbyAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actw
 * JD-Core Version:    0.7.0.1
 */