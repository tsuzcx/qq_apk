import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class lkg
  implements lkf
{
  private ndi.c jdField_a_of_type_Ndi$c;
  private nhk jdField_a_of_type_Nhk;
  private ndi b;
  private lie c;
  private Context mContext;
  
  public lkg(Context paramContext, ndi.c paramc, ndi paramndi)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Ndi$c = paramc;
    this.b = paramndi;
  }
  
  public static List<articlesummary.PackJumpInfo> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter special topic link list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo)
  {
    int i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_Nhk.n[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_Nhk.kP.setOnClickListener(null);
    switch (paramInt)
    {
    }
    List localList;
    int j;
    for (;;)
    {
      localList = null;
      for (;;)
      {
        if ((localList != null) && (localList.size() == 1)) {
          a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
        }
        if ((localList == null) || (localList.size() <= 1)) {
          break label213;
        }
        j = 1;
        i = 0;
        while (i < localList.size())
        {
          if (((articlesummary.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
            j = 0;
          }
          i += 1;
        }
        localList = a(paramArticleInfo);
        continue;
        localList = b(paramArticleInfo);
      }
      a(paramInt, paramArticleInfo, null);
    }
    if (j != 0)
    {
      a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
      label213:
      return;
    }
    a(paramInt, paramArticleInfo, localList);
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, List<articlesummary.PackJumpInfo> paramList)
  {
    this.jdField_a_of_type_Nhk.kP.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_Nhk.n[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Nhk.k[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Nhk.n[3].setVisibility(8);
    paramArticleInfo = paramList.iterator();
    Object localObject1;
    int i;
    for (paramInt = 0; paramArticleInfo.hasNext(); paramInt = i)
    {
      localObject1 = (articlesummary.PackJumpInfo)paramArticleInfo.next();
      i = paramInt;
      if (((articlesummary.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Nhk.n[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_Nhk.n[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_Nhk.n[3].setVisibility(0);
          this.jdField_a_of_type_Nhk.n[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_Nhk.n[3].setOnClickListener(new lkm(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_Nhk.n[paramInt].setVisibility(0);
      this.jdField_a_of_type_Nhk.n[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_Nhk.n[paramInt].setOnClickListener(new lkn(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Nhk.k[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_Nhk.n[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.jdField_a_of_type_Nhk.k[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_Nhk.n[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new lkk(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Nhk.n[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_Nhk.n[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_Nhk.n[3].setVisibility(0);
        this.jdField_a_of_type_Nhk.n[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_Nhk.n[3].setOnClickListener(paramArticleInfo);
        this.jdField_a_of_type_Nhk.kP.setOnClickListener(paramArticleInfo);
        return;
      }
      this.jdField_a_of_type_Nhk.n[0].setVisibility(0);
      this.jdField_a_of_type_Nhk.n[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_Nhk.n[0].setOnClickListener(paramArticleInfo);
      this.jdField_a_of_type_Nhk.kP.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new lkl(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Nhk.n[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_Nhk.n[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Nhk.n[3].setVisibility(0);
    this.jdField_a_of_type_Nhk.n[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_Nhk.n[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_Nhk.kP.setOnClickListener(paramPackJumpInfo);
  }
  
  public static void av(int paramInt, String paramString) {}
  
  public static List<articlesummary.PackJumpInfo> b(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter friend recommend link list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  public void a(nhk paramnhk, lie paramlie, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Nhk = paramnhk;
    this.c = paramlie;
    paramlie = this.c.a();
    if (paramlie == null) {
      return;
    }
    label60:
    label206:
    label238:
    long l;
    label130:
    String str2;
    if (this.jdField_a_of_type_Nhk.kP != null)
    {
      paramnhk = this.jdField_a_of_type_Nhk.kP;
      if (this.c.Cq())
      {
        paramInt = 0;
        paramnhk.setVisibility(paramInt);
      }
    }
    else
    {
      if (this.c.Cq())
      {
        this.jdField_a_of_type_Nhk.aXa();
        a(this.c.getJumpType(), paramlie);
      }
      if (this.jdField_a_of_type_Nhk.mA != null)
      {
        paramnhk = this.jdField_a_of_type_Nhk.mA;
        if (!this.c.Cr()) {
          break label715;
        }
        paramInt = 0;
        paramnhk.setVisibility(paramInt);
      }
      if (this.c.Cr())
      {
        this.jdField_a_of_type_Nhk.aXb();
        this.jdField_a_of_type_Nhk.tc.setText(paramlie.mArticleFriendLikeText);
      }
      switch (paramlie.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_Nhk.tc.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (this.jdField_a_of_type_Nhk.commentView != null)
        {
          paramnhk = this.jdField_a_of_type_Nhk.commentView;
          if (this.c.Cs())
          {
            paramInt = 0;
            paramnhk.setVisibility(paramInt);
          }
        }
        else
        {
          if (this.c.Cs())
          {
            this.jdField_a_of_type_Nhk.aXc();
            this.jdField_a_of_type_Nhk.commentView.setOnClickListener(null);
            paramnhk = (articlesummary.CommentInfo)paramlie.mCommentsObj.get(0);
            l = paramnhk.uint64_uin.get();
            str2 = paramnhk.str_content.get();
            String str1 = paramnhk.str_jump_url.get();
            if (!kxm.AI()) {
              break label758;
            }
            paramnhk = aqgv.A((QQAppInterface)kxm.getAppRuntime(), String.valueOf(l));
            label335:
            String str3 = kxm.ew(paramnhk);
            if (str3 == null) {
              break label771;
            }
            paramnhk = new SpannableString(str3 + ":  " + str2);
            paramnhk.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.mContext.getResources().getColor(2131167595)), 0, str3.length(), 33);
            this.jdField_a_of_type_Nhk.td.setVisibility(0);
            this.jdField_a_of_type_Nhk.td.setText(str3 + ":  ");
            label454:
            this.jdField_a_of_type_Nhk.fW.setText(paramnhk);
            this.jdField_a_of_type_Nhk.fW.setOnClickListener(new lkh(this, str1, paramlie));
            this.jdField_a_of_type_Nhk.td.setOnClickListener(new lki(this, l, paramlie));
            if (!this.c.Cu()) {
              break label796;
            }
            this.jdField_a_of_type_Nhk.mB.setVisibility(0);
          }
          label530:
          if (this.jdField_a_of_type_Nhk.ev != null)
          {
            paramnhk = this.jdField_a_of_type_Nhk.ev;
            if (!this.c.Ct()) {
              break label811;
            }
            paramInt = 0;
            label562:
            paramnhk.setVisibility(paramInt);
          }
          if (this.c.Ct())
          {
            paramnhk = (LinearLayout.LayoutParams)this.jdField_a_of_type_Nhk.ev.getLayoutParams();
            mde.a(this.mContext, this.c, paramnhk, this.jdField_a_of_type_Nhk.ev);
            this.jdField_a_of_type_Nhk.ev.setLayoutParams(paramnhk);
          }
          if (this.jdField_a_of_type_Nhk.mC != null)
          {
            paramnhk = this.jdField_a_of_type_Nhk.mC;
            if (!this.c.Cv()) {
              break label817;
            }
          }
        }
        break;
      }
    }
    label771:
    label796:
    label811:
    label817:
    for (paramInt = i;; paramInt = 8)
    {
      paramnhk.setVisibility(paramInt);
      if ((!this.c.Cv()) || (!this.jdField_a_of_type_Nhk.Fy())) {
        break;
      }
      this.jdField_a_of_type_Nhk.mC.setOnClickListener(new lkj(this));
      lcc.a().bZ(null);
      return;
      paramInt = 8;
      break label60;
      label715:
      paramInt = 8;
      break label130;
      paramnhk = this.mContext.getResources().getDrawable(2130842611);
      this.jdField_a_of_type_Nhk.tc.setCompoundDrawablesWithIntrinsicBounds(paramnhk, null, null, null);
      break label206;
      paramInt = 8;
      break label238;
      label758:
      paramnhk = this.b.az(l);
      break label335;
      paramnhk = new SpannableString(str2);
      this.jdField_a_of_type_Nhk.td.setVisibility(8);
      break label454;
      this.jdField_a_of_type_Nhk.mB.setVisibility(8);
      break label530;
      paramInt = 8;
      break label562;
    }
  }
  
  public void a(nhk paramnhk, lie paramlie, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkg
 * JD-Core Version:    0.7.0.1
 */