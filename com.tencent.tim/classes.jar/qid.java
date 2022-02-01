import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView.a;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.lang.ref.WeakReference;
import java.util.List;

public class qid
  extends rsd
{
  public static final String KEY = "PlayerCommentSegment";
  private StoryPlayerCommentListView.a jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a;
  private qhy jdField_a_of_type_Qhy;
  private qid.a jdField_a_of_type_Qid$a = new qid.a(this);
  private qid.b jdField_a_of_type_Qid$b = new qid.b();
  private qid.c jdField_a_of_type_Qid$c = new qid.c();
  public qru a;
  private int mSource;
  
  public qid(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean isOpen()
  {
    return (this.jdField_a_of_type_Qhy == null) || (this.jdField_a_of_type_Qhy.isOpen());
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Qru == null) || (paramInt > this.jdField_a_of_type_Qru.h(isOpen()).size()))
    {
      ram.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramqyd.getItemView();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Qru.h(isOpen()).get(paramInt);
    if (localCommentEntry == null)
    {
      ram.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramqyd.getItemView();
    }
    paramViewGroup = (ImageView)paramqyd.get(2131363175);
    TextView localTextView1 = (TextView)paramqyd.get(2131372369);
    TextView localTextView2 = (TextView)paramqyd.get(2131364999);
    Object localObject1 = (LinearLayout)paramqyd.get(2131364993);
    TextView localTextView3 = (TextView)paramqyd.get(2131370779);
    ImageView localImageView = (ImageView)paramqyd.get(2131365010);
    ProgressBar localProgressBar = (ProgressBar)paramqyd.get(2131365035);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.isNightMode())
      {
        localTextView2.setBackgroundResource(2130847326);
        localTextView1.setTextColor(this.context.getResources().getColor(2131166761));
        localTextView2.setTextColor(this.context.getResources().getColor(2131166761));
        localTextView3.setBackgroundColor(this.context.getResources().getColor(2131166759));
      }
      return paramqyd.getItemView();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Qid$a.hashCode() + "bubble_style";
    Object localObject2 = pre.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((ptf)psx.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = aqhu.at();
      if (localQQUserUIItem != null) {
        break label616;
      }
      localObject1 = "";
      label383:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label626;
      }
      paramInt = 1;
      label393:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label631;
      }
      localObject2 = "V";
      label405:
      if (localQQUserUIItem != null) {
        break label638;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      label416:
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
        break label751;
      }
      paramViewGroup = new SpannableStringBuilder(qem.auW);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        qrx.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
      }
      localTextView1.setText(paramViewGroup);
      if (localCommentEntry.status != 2) {
        break label791;
      }
      localImageView.setVisibility(0);
      localProgressBar.setVisibility(8);
    }
    for (;;)
    {
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Qid$b);
      localTextView2.setSpannableFactory(aofk.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = qrx.b(this.context, this.jdField_a_of_type_Qru.d, localCommentEntry, this.jdField_a_of_type_Qid$a);
      localTextView2.setText((CharSequence)localObject2);
      if (localCommentEntry.isReply())
      {
        localQQUserUIItem = ((ptf)psx.a(2)).c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          break label352;
        }
        pre.a().a((String)localObject1, (CharSequence)localObject2);
        break label352;
      }
      pre.a().a((String)localObject1, (CharSequence)localObject2);
      break label352;
      label616:
      localObject1 = localQQUserUIItem.getUserIconUrl();
      break label383;
      label626:
      paramInt = 0;
      break label393;
      label631:
      localObject2 = "";
      break label405;
      label638:
      if ((localQQUserUIItem.isVipButNoFriend()) || (localQQUserUIItem.isNotDovUser()))
      {
        rpq.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(aqdj.a(qem.getQQAppInterface(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (jqc.isValidUrl(localQQUserUIItem.headUrl))
      {
        rpq.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      break label416;
      label751:
      if (localQQUserUIItem.isVipButNoFriend())
      {
        paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.nickName);
        break label440;
      }
      paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.getDisplayName());
      break label440;
      label791:
      localImageView.setVisibility(8);
      if (localCommentEntry.status == 1) {
        localProgressBar.setVisibility(0);
      } else {
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  public CommentEntry a(int paramInt)
  {
    if ((this.jdField_a_of_type_Qru == null) || (paramInt >= this.jdField_a_of_type_Qru.h(this.jdField_a_of_type_Qhy.isOpen()).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Qru.h(this.jdField_a_of_type_Qhy.isOpen()).get(paramInt);
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new qyd(LayoutInflater.from(this.context).inflate(2131561841, paramViewGroup, false));
    paramViewGroup.b(this.jdField_a_of_type_Qid$c);
    paramViewGroup.get(2131363175).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131372369).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131365000).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131365000).setOnLongClickListener(paramViewGroup);
    paramViewGroup.get(2131370779).setOnClickListener(paramViewGroup);
    paramViewGroup.get(2131370779).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(qhy paramqhy, StoryPlayerCommentListView.a parama, int paramInt)
  {
    this.jdField_a_of_type_Qhy = paramqhy;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView$a = parama;
    this.mSource = paramInt;
  }
  
  public void c(qru paramqru)
  {
    this.jdField_a_of_type_Qru = paramqru;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null)) {
      return this.jdField_a_of_type_Qru.h(isOpen()).size();
    }
    return 0;
  }
  
  public String getKey()
  {
    return "PlayerCommentSegment";
  }
  
  public static class a
    implements qrx.a
  {
    private WeakReference<qid> cV;
    
    public a(qid paramqid)
    {
      this.cV = new WeakReference(paramqid);
    }
    
    public void bs(String paramString, int paramInt)
    {
      ram.b("Q.qqstory.detail.DetailCommentSegment", "on nick click. unionId = %s.", paramString);
      qid localqid = (qid)this.cV.get();
      if ((localqid == null) || (paramInt == 1002) || (paramInt == 1003)) {}
      do
      {
        return;
        ppf.f(qid.a(localqid), 12, paramString);
      } while ((localqid.a == null) || (localqid.a.d == null));
      paramInt = rar.a(localqid.a.d);
      if (localqid.a.d.getOwner().isMe()) {}
      for (paramString = "1";; paramString = "2")
      {
        rar.a("home_page", "clk_reply_nick", paramInt, 0, new String[] { paramString, rar.bX(4444), "", localqid.a.d.feedId });
        return;
      }
    }
  }
  
  public static class b
    implements View.OnTouchListener
  {
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      Object localObject = ((TextView)paramView).getText();
      localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
      paramView = (TextView)paramView;
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 0))
      {
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = paramView.getTotalPaddingLeft();
        int n = paramView.getTotalPaddingTop();
        int i1 = paramView.getScrollX();
        int i2 = paramView.getScrollY();
        paramMotionEvent = paramView.getLayout();
        j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
        paramMotionEvent = (ClickableSpan[])((Spannable)localObject).getSpans(j, j, ClickableSpan.class);
        if (paramMotionEvent.length != 0)
        {
          if (i == 1) {
            paramMotionEvent[0].onClick(paramView);
          }
          return true;
        }
      }
      return false;
    }
  }
  
  public class c
    extends qwo
  {
    public c() {}
    
    public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
    {
      if ((paramInt < 0) || (paramInt > qid.this.a.h(qid.a(qid.this)).size())) {}
      do
      {
        return;
        paramObject = (CommentEntry)qid.this.a.h(qid.a(qid.this)).get(paramInt);
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
      ppf.f(paramView.getContext(), 12, paramObject.authorUnionId);
      return;
      if (qid.a(qid.this) != null) {
        qid.a(qid.this).a(paramObject, paramInt, qid.a(qid.this).sB());
      }
      qid.a(qid.this).sD(qid.a(qid.this).isOpen());
    }
    
    public void b(int paramInt, View paramView, Object paramObject, qyd paramqyd)
    {
      if ((paramInt < 0) || (paramInt > qid.this.a.h(qid.a(qid.this)).size())) {
        return;
      }
      paramObject = (CommentEntry)qid.this.a.h(qid.a(qid.this)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131365000: 
        paramView = qid.a(qid.this).a();
        if ((paramView != null) && (paramView.d != null)) {
          if (!paramView.d.getOwner().isMe()) {
            break label194;
          }
        }
        label194:
        for (paramView = "2";; paramView = "1")
        {
          rar.a("home_page", "press_reply", 0, 0, new String[] { paramView, rar.bX(qid.a(qid.this)) });
          if (qid.a(qid.this) == null) {
            break;
          }
          qid.a(qid.this).b(paramObject, paramInt, qid.a(qid.this).sB());
          return;
        }
      }
      qid.a(qid.this).sD(qid.a(qid.this).isOpen());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qid
 * JD-Core Version:    0.7.0.1
 */