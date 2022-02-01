import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aliz
  implements wvs
{
  public aqju aB;
  private BaseChatPie c;
  private int duH = 12;
  private EntityManager mEntityManager;
  
  public aliz(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.mEntityManager = this.c.getApp().a().createEntityManager();
    }
  }
  
  private ahvu a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = ahwb.a(new String(paramArrayOfByte, "utf-8"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void a(aqju paramaqju, ahvu paramahvu, PushDialogTemplate paramPushDialogTemplate)
  {
    paramahvu = paramahvu.a();
    if (paramahvu.Fo() != 6) {}
    Object localObject3;
    Object localObject2;
    label438:
    do
    {
      return;
      for (;;)
      {
        paramahvu = paramahvu.dh();
        if ((paramahvu != null) && (paramahvu.size() != 0))
        {
          paramahvu = paramahvu.iterator();
          while (paramahvu.hasNext())
          {
            localObject1 = (ahvu.a)paramahvu.next();
            localObject3 = ((ahvu.a)localObject1).L();
            localObject2 = ((ahvu.a)localObject1).dh();
            if (((ahvu.a)localObject1).Fo() == 7)
            {
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                paramaqju.setTitle((String)localObject1);
              }
            }
            else
            {
              if (((ahvu.a)localObject1).Fo() != 8) {
                break label438;
              }
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(1));
              if ((localObject2 != null) && (((List)localObject2).size() != 0))
              {
                localObject1 = new SpannableStringBuilder();
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  Object localObject4 = (ahvu.a)((Iterator)localObject2).next();
                  localObject3 = ((ahvu.a)localObject4).L();
                  String str1;
                  if (((ahvu.a)localObject4).Fo() == 2)
                  {
                    if (localObject3 != null)
                    {
                      localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                      str1 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                      if (!TextUtils.isEmpty((CharSequence)localObject4))
                      {
                        localObject3 = new SpannableString((CharSequence)localObject4);
                        ((SpannableString)localObject3).setSpan(Integer.valueOf(Color.parseColor("#03081A")), 0, ((SpannableString)localObject3).length(), 33);
                        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
                      }
                    }
                  }
                  else if ((((ahvu.a)localObject4).Fo() == 3) && (localObject3 != null))
                  {
                    localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                    str1 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                    String str2 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                    localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                    SpannableString localSpannableString = new SpannableString((CharSequence)localObject4);
                    localSpannableString.setSpan(new aljb(this, str1, (String)localObject3, str2), 0, ((String)localObject4).length(), 33);
                    ((SpannableStringBuilder)localObject1).append(localSpannableString);
                  }
                }
                paramaqju.setMessageWithoutAutoLink((CharSequence)localObject1);
              }
            }
          }
        }
      }
    } while ((((ahvu.a)localObject1).Fo() != 9) || (localObject2 == null));
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    label465:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ahvu.a)((Iterator)localObject1).next();
      if (((ahvu.a)localObject2).Fo() != 10) {
        break label590;
      }
      localObject3 = ((ahvu.a)localObject2).L();
      localObject2 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
      if (i != 0) {
        break label564;
      }
      paramaqju.setNegativeButton((String)localObject2, new aljc(this, (String)localObject3, paramPushDialogTemplate));
    }
    label555:
    label564:
    label590:
    label591:
    for (;;)
    {
      i += 1;
      for (;;)
      {
        break label465;
        break;
        if (i != 1) {
          break label591;
        }
        paramaqju.setPositiveButton((String)localObject2, new aljd(this, (String)localObject3));
        break label555;
      }
    }
  }
  
  private void a(EntityManager paramEntityManager, long paramLong)
  {
    aljf.a().a(paramEntityManager, paramLong, new alja(this));
  }
  
  private void a(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 103) && (this.mEntityManager != null)) {
      aljf.a().a(this.mEntityManager, paramPushDialogTemplate);
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.mEntityManager != null)) {
      aljf.a().b(this.mEntityManager, paramPushDialogTemplate);
    }
    if (this.aB != null) {
      this.aB.dismiss();
    }
  }
  
  public int[] C()
  {
    return new int[] { 10, 4, 7 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 10: 
      do
      {
        return;
        this.duH = 10;
      } while (this.aB == null);
      this.aB.dismiss();
      return;
    case 4: 
      this.duH = 4;
      return;
    }
    dGo();
  }
  
  public void a(PushDialogTemplate paramPushDialogTemplate, int paramInt1, int paramInt2)
  {
    ahvu localahvu;
    if ((paramPushDialogTemplate != null) && (paramPushDialogTemplate.templ_content != null))
    {
      localahvu = a(paramPushDialogTemplate.templ_content);
      if (localahvu != null)
      {
        if (this.aB != null) {
          break label214;
        }
        this.aB = new aqju(this.c.mContext, 2131756467);
        this.aB.setContentView(2131559151);
        this.aB.setCanceledOnTouchOutside(false);
        LinearLayout localLinearLayout = (LinearLayout)this.aB.findViewById(2131363579);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
        localLayoutParams.leftMargin = aqcx.dip2px(this.c.mContext, 30.0F);
        localLayoutParams.rightMargin = aqcx.dip2px(this.c.mContext, 30.0F);
        localLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      a(this.aB, localahvu, paramPushDialogTemplate);
      this.aB.show();
      if (this.duH != 4) {
        break label264;
      }
      a(paramPushDialogTemplate, paramInt2);
      if (!paramPushDialogTemplate.isFriendBanned()) {
        break;
      }
      anot.a(this.c.getApp(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
      return;
      label214:
      this.aB.dismiss();
    }
    anot.a(this.c.getApp(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
    return;
    label264:
    b(paramPushDialogTemplate, paramInt1);
  }
  
  public void dGo()
  {
    String str;
    if (this.c != null)
    {
      str = this.c.sessionInfo.aTl;
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      a(this.mEntityManager, Long.valueOf(str).longValue());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AIOPushDialogHelper", 1, "db search error: ", localException);
    }
  }
  
  public void f(List<PushDialogTemplate> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        a((PushDialogTemplate)paramList.get(i), paramInt1, paramInt2);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aliz
 * JD-Core Version:    0.7.0.1
 */