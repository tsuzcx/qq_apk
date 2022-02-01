import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class amoj
  extends ampt
{
  private long ajT;
  private DiscussionMemberInfo b;
  private int dDe;
  private String keyword;
  private String subTitle;
  private String title;
  
  public amoj(QQAppInterface paramQQAppInterface, int paramInt, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.b = paramDiscussionMemberInfo;
  }
  
  private void initTitle()
  {
    switch (this.dDe)
    {
    default: 
      this.title = "";
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.b.inteRemark))
      {
        this.title = this.b.inteRemark;
        this.subTitle = this.b.memberUin;
        return;
      }
      if (!TextUtils.isEmpty(this.b.memberName))
      {
        this.title = this.b.memberName;
        this.subTitle = this.b.memberUin;
        return;
      }
      this.title = this.b.memberUin;
      this.subTitle = null;
      return;
    case 2: 
      this.title = this.b.inteRemark;
      if (!TextUtils.isEmpty(this.b.memberName))
      {
        this.subTitle = this.b.memberName;
        return;
      }
      this.subTitle = this.b.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.b.inteRemark))
    {
      this.title = this.b.inteRemark;
      this.subTitle = this.b.memberName;
      return;
    }
    this.title = this.b.memberName;
    this.subTitle = this.b.memberUin;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 1;
  }
  
  public Object S()
  {
    return this.b.memberUin;
  }
  
  protected long au(String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((acdu)this.app.getManager(53)).a(this.b.discussionUin);
    if ((localDiscussionInfo == null) || (localDiscussionInfo.isDiscussHrMeeting()) || (localDiscussionInfo.isHidden()))
    {
      this.ajT = -9223372036854775808L;
      return this.ajT;
    }
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    long l = amxk.b(paramString, this.b.inteRemark, amjz.aiX);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDe = 2;
    }
    l = amxk.b(paramString, this.b.memberName, amjz.aiY);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDe = 1;
    }
    l = amxk.a(paramString, this.b.memberUin, amjz.ajb, false);
    if (l > this.ajT)
    {
      this.ajT = l;
      this.dDe = 0;
    }
    if (this.ajT != -9223372036854775808L)
    {
      this.ajT += amjz.aju;
      initTitle();
    }
    return this.ajT;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (amxk.lo(this.fromType))
    {
      aalb.bwg = true;
      aalb.a(paramView.getContext(), this.b.memberUin, this.b.discussionUin, 1004, this.b.memberName, false);
      amxk.a(this.keyword, 20, 1, paramView);
      aclj.Q(this.app, this.keyword);
      amxk.d(this.app, getTitle().toString(), this.b.memberUin, this.b.discussionUin, 1004);
      amxk.a(this.keyword, 20, paramView, false);
      amxk.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        amxk.d("search", "contact", "contacts", 0, 0, new String[] { amxk.fc(this.fromType) });
      }
      if (((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.keyword, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp != null) && (!TextUtils.isEmpty(this.cbp))) {
          amub.a(null, 0, this.fromType, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      amub.a(null, 0, this.fromType, "0X8009D37", 0, 0, null, null);
      return;
    }
    amxk.a(paramView, this);
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    if (amxk.lo(this.fromType)) {
      return acfp.m(2131704468);
    }
    return acfp.m(2131704429);
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public String getUin()
  {
    return this.b.memberUin;
  }
  
  public int lk()
  {
    return 1004;
  }
  
  public int pG()
  {
    return 1;
  }
  
  public Pair<CharSequence, CharSequence> s()
  {
    switch (this.dDe)
    {
    default: 
      return null;
    case 0: 
      if (!TextUtils.isEmpty(this.b.inteRemark)) {
        return new Pair(this.b.inteRemark, amxk.c(this.b.memberUin, this.keyword, 6, false));
      }
      if (!TextUtils.isEmpty(this.b.memberName)) {
        return new Pair(this.b.memberName, amxk.c(this.b.memberUin, this.keyword, 6, false));
      }
      return new Pair(amxk.b(this.b.memberUin, this.keyword, 6, false), null);
    case 2: 
      return new Pair(amxk.b(this.b.inteRemark, this.keyword, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.b.inteRemark)) {
      return new Pair(this.b.inteRemark, amxk.c(this.b.memberName, this.keyword, 6, true));
    }
    return new Pair(amxk.b(this.b.memberName, this.keyword, 6, true), null);
  }
  
  public CharSequence y()
  {
    Object localObject = getTitle();
    CharSequence localCharSequence = f();
    switch (this.dDe)
    {
    }
    do
    {
      localObject = super.y();
      SpannableStringBuilder localSpannableStringBuilder;
      do
      {
        return localObject;
        localSpannableStringBuilder = new SpannableStringBuilder();
        if (localObject != null) {
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        localObject = localSpannableStringBuilder;
      } while (localCharSequence == null);
      localSpannableStringBuilder.append(localCharSequence);
      return localSpannableStringBuilder;
      return localObject;
      if (TextUtils.isEmpty(this.b.inteRemark)) {
        return localObject;
      }
    } while ((localCharSequence == null) || (localCharSequence.length() <= 2));
    return localCharSequence.subSequence(1, localCharSequence.length() - 1);
  }
  
  public String za()
  {
    return this.title;
  }
  
  public String zb()
  {
    return this.subTitle;
  }
  
  public String zc()
  {
    return this.b.discussionUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoj
 * JD-Core Version:    0.7.0.1
 */