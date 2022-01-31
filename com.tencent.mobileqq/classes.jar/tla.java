import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogTopGestureLayout;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import javax.annotation.Nullable;

public class tla
  extends Dialog
{
  private int jdField_a_of_type_Int;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CommentFloatDialogTopGestureLayout jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout;
  private StoryPlayerCommentListView jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
  private String jdField_a_of_type_JavaLangString;
  private tlj jdField_a_of_type_Tlj;
  private ucw jdField_a_of_type_Ucw;
  @Nullable
  private udl jdField_a_of_type_Udl;
  private boolean jdField_a_of_type_Boolean;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public tla(@NonNull Context paramContext, @NonNull String paramString1, tlj paramtlj, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, 2131689578);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Tlj = paramtlj;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495805, null);
    a(paramContext, paramString2);
    this.jdField_a_of_type_Tlj.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Tlj.b();
    super.setContentView(paramContext);
    paramContext = getWindow();
    if (paramContext != null)
    {
      paramContext.setSoftInputMode(16);
      paramString1 = paramContext.getAttributes();
      paramString1.width = -1;
      paramString1.height = vms.c(getContext());
      paramString1.flags |= 0x20;
      paramString1.gravity = 80;
      paramContext.setAttributes(paramString1);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        getWindow().addFlags(67108864);
        paramContext = new SystemBarCompact(this, true, getContext().getResources().getColor(17170445));
        paramContext.setStatusBarDrawable(null);
        paramContext.init();
      }
    }
  }
  
  private void a(View paramView, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout = ((CommentFloatDialogTopGestureLayout)paramView.findViewById(2131299132));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131299097));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView = ((StoryPlayerCommentListView)paramView.findViewById(2131298944));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.a(this.jdField_a_of_type_Tlj, new tli(this, null), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.a(this, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout);
    if (QQStoryContext.a())
    {
      ((InputLinearLayout)paramView.findViewById(2131309380)).setBackgroundColor(getContext().getResources().getColor(2131100757));
      ((LinearLayout)paramView.findViewById(2131297822)).setBackgroundColor(getContext().getResources().getColor(2131100756));
      ((XEditTextEx)paramView.findViewById(2131300153)).setHintTextColor(getContext().getResources().getColor(2131100758));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.setBackgroundColor(getContext().getResources().getColor(2131100756));
      paramView.findViewById(2131311586).setBackgroundColor(getContext().getResources().getColor(2131100756));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.setBackgroundColor(getContext().getResources().getColor(2131100756));
      paramView.findViewById(2131299701).setBackgroundColor(getContext().getResources().getColor(2131100757));
    }
    paramView.setOnClickListener(new tlb(this));
    ImageView localImageView = (ImageView)paramView.findViewById(2131298711);
    localImageView.setOnClickListener(new tlc(this));
    if (QQStoryContext.a()) {
      localImageView.setBackgroundResource(2130845359);
    }
    ((TextView)paramView.findViewById(2131311534)).setText(paramString);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new tld(this));
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_Udl != null) {
      return this.jdField_a_of_type_Udl.a.getText();
    }
    return "";
  }
  
  public void a()
  {
    if (!this.c)
    {
      this.c = true;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      this.c = true;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, paramInt, 1, 1.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new tle(this));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(localTranslateAnimation);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.a != null) && (this.jdField_a_of_type_Ucw.a.getOwner().isMe());
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.a != null) && (this.jdField_a_of_type_Ucw.a.getOwner().isVip());
  }
  
  protected void onStart()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFloatdialogCommentFloatDialogTopGestureLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tla
 * JD-Core Version:    0.7.0.1
 */