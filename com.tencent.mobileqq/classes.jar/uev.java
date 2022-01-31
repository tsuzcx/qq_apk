import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class uev
  extends vpv
{
  public static final String KEY = "DetailCommentSegment";
  private ucg jdField_a_of_type_Ucg;
  public ucw a;
  private uew jdField_a_of_type_Uew = new uew(1);
  private uex jdField_a_of_type_Uex = new uex();
  private uey jdField_a_of_type_Uey = new uey(this);
  private boolean b;
  
  public uev(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null)) {
      return this.jdField_a_of_type_Ucw.a(this.b).size();
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Ucw == null) || (paramInt > this.jdField_a_of_type_Ucw.a(this.b).size()))
    {
      urk.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. position is out of bound.");
      return paramunw.a();
    }
    CommentEntry localCommentEntry = (CommentEntry)this.jdField_a_of_type_Ucw.a(this.b).get(paramInt);
    if (localCommentEntry == null)
    {
      urk.e("Q.qqstory.detail.DetailCommentSegment", "bind view failed. data is null.");
      return paramunw.a();
    }
    paramViewGroup = (ImageView)paramunw.a(2131297399);
    TextView localTextView1 = (TextView)paramunw.a(2131305143);
    TextView localTextView2 = (TextView)paramunw.a(2131298909);
    Object localObject1 = (LinearLayout)paramunw.a(2131298903);
    TextView localTextView3 = (TextView)paramunw.a(2131303805);
    ImageView localImageView = (ImageView)paramunw.a(2131298920);
    ProgressBar localProgressBar = (ProgressBar)paramunw.a(2131298945);
    if (localCommentEntry.type == 1)
    {
      paramViewGroup.setVisibility(8);
      ((LinearLayout)localObject1).setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView3.setText(localCommentEntry.content);
      if (QQStoryContext.a())
      {
        localTextView2.setBackgroundResource(2130845363);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
        localTextView2.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
        localTextView3.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
      }
      return paramunw.a();
    }
    paramViewGroup.setVisibility(0);
    ((LinearLayout)localObject1).setVisibility(0);
    localTextView3.setVisibility(8);
    localObject1 = localCommentEntry.commentId + localCommentEntry.feedId + localCommentEntry.status + this.jdField_a_of_type_Uew.hashCode() + "bubble_style";
    Object localObject2 = sob.a().a((String)localObject1);
    label352:
    QQUserUIItem localQQUserUIItem;
    Drawable localDrawable;
    if (localObject2 != null)
    {
      localTextView2.setText((CharSequence)localObject2);
      localQQUserUIItem = ((sqs)sqg.a(2)).c(localCommentEntry.authorUnionId);
      localDrawable = bacm.b();
      if (localQQUserUIItem != null) {
        break label565;
      }
      localObject1 = "";
      label383:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label575;
      }
      paramInt = 1;
      label393:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label580;
      }
      localObject2 = "V";
      label405:
      if (localQQUserUIItem != null) {
        break label587;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      label416:
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
        break label700;
      }
      paramViewGroup = new SpannableStringBuilder(tfy.b);
      label440:
      if (paramInt != 0)
      {
        paramInt = paramViewGroup.length();
        paramViewGroup.append((CharSequence)localObject2);
        udd.a(paramViewGroup, (String)localObject1, paramInt, paramViewGroup.length());
      }
      localTextView1.setText(paramViewGroup);
      if (localCommentEntry.status != 2) {
        break label740;
      }
      localImageView.setVisibility(0);
      localProgressBar.setVisibility(8);
    }
    for (;;)
    {
      localTextView2.setOnTouchListener(this.jdField_a_of_type_Uex);
      localTextView2.setSpannableFactory(axkd.a);
      localTextView2.setTextColor(-16777216);
      break;
      localObject2 = udd.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ucw.a, localCommentEntry, this.jdField_a_of_type_Uew);
      localTextView2.setText((CharSequence)localObject2);
      sob.a().a((String)localObject1, (CharSequence)localObject2);
      break label352;
      label565:
      localObject1 = localQQUserUIItem.getUserIconUrl();
      break label383;
      label575:
      paramInt = 0;
      break label393;
      label580:
      localObject2 = "";
      break label405;
      label587:
      if ((localQQUserUIItem.isVipButNoFriend()) || (localQQUserUIItem.isNotDovUser()))
      {
        vms.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      if (!TextUtils.isEmpty(localQQUserUIItem.qq))
      {
        paramViewGroup.setImageDrawable(azwp.a(tfy.a(), 1, localQQUserUIItem.qq, 3, localDrawable, localDrawable));
        break label416;
      }
      if (mpl.a(localQQUserUIItem.headUrl))
      {
        vms.b(paramViewGroup, localQQUserUIItem.headUrl, 60, 60, localDrawable, "QQStory_player");
        break label416;
      }
      paramViewGroup.setImageDrawable(localDrawable);
      break label416;
      label700:
      if (localQQUserUIItem.isVipButNoFriend())
      {
        paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.nickName);
        break label440;
      }
      paramViewGroup = new SpannableStringBuilder(localQQUserUIItem.getDisplayName());
      break label440;
      label740:
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
    if ((this.jdField_a_of_type_Ucw == null) || (paramInt >= this.jdField_a_of_type_Ucw.a(this.b).size())) {
      return null;
    }
    return (CommentEntry)this.jdField_a_of_type_Ucw.a(this.b).get(paramInt);
  }
  
  public String a()
  {
    return "DetailCommentSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495650, paramViewGroup, false));
    paramViewGroup.a(this.jdField_a_of_type_Uey);
    paramViewGroup.a(2131297399).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131305143).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131298910).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131298910).setOnLongClickListener(paramViewGroup);
    paramViewGroup.a(2131303805).setOnClickListener(paramViewGroup);
    paramViewGroup.a(2131303805).setOnLongClickListener(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
    this.jdField_a_of_type_Uew.a(paramucg);
  }
  
  public void a(ucw paramucw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ucw = paramucw;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uev
 * JD-Core Version:    0.7.0.1
 */