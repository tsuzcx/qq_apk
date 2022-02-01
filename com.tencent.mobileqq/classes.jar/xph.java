import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xph
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private PressEffectTextView jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
  private xpi jdField_a_of_type_Xpi;
  private String c;
  
  public xph(View paramView)
  {
    super(paramView);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
    int i;
    label42:
    Context localContext;
    if (paramBoolean)
    {
      i = 0;
      ((PressEffectTextView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (!(localObject instanceof LinearLayout.LayoutParams)) {
        break label85;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      localContext = this.jdField_a_of_type_AndroidViewView.getContext();
      if (!paramBoolean) {
        break label101;
      }
    }
    label85:
    label101:
    for (float f = 10.0F;; f = 30.0F)
    {
      ((LinearLayout.LayoutParams)localObject).bottomMargin = UIUtils.dip2px(localContext, f);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
      localObject = new LinearLayout.LayoutParams(-2, -2);
      break label42;
    }
  }
  
  public String a()
  {
    return "NewGuideNodeWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView = new PressEffectTextView(this.jdField_a_of_type_AndroidViewView.getContext(), null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setId(1001);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setPadding(UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 38.0F));
    localLayoutParams.bottomMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 4.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(1000);
    this.jdField_a_of_type_AndroidWidgetButton.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839360);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localLayoutParams = new RelativeLayout.LayoutParams(UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 40.0F));
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(2, 1001);
    localLayoutParams.bottomMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 10.0F);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    a(true);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Xpi = new xpi(this);
    a(this.jdField_a_of_type_Xpi);
  }
  
  public void a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject1 = null;
    if ((paramxhf.a == null) || (paramxhf.a.jdField_a_of_type_JavaUtilList == null) || (paramxhf.a.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.c = paramStoryVideoItem.mVid;
      k();
      return;
    }
    paramxhf = paramxhf.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxhf.hasNext())
    {
      wmq localwmq = (wmq)paramxhf.next();
      if (TextUtils.equals(paramStoryVideoItem.mVid, localwmq.jdField_a_of_type_JavaLangString))
      {
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
        int i;
        if (localwmq.jdField_a_of_type_Int != 0)
        {
          paramxhf = localwmq.c;
          ((Button)localObject2).setText(paramxhf);
          this.jdField_a_of_type_AndroidWidgetButton.setTag(localwmq.d);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
          paramxhf = localObject1;
          if (localwmq.b != 0) {
            paramxhf = localwmq.e;
          }
          ((PressEffectTextView)localObject2).setText(paramxhf);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTag(localwmq.f);
          if ((localwmq.b == 0) || (TextUtils.isEmpty(localwmq.e))) {
            break label273;
          }
          i = 1;
          label196:
          if ((i != 0) && (!TextUtils.equals(this.c, paramStoryVideoItem.mVid)))
          {
            ykv.a("play_video", "exp_all_tips", 0, 0, new String[0]);
            this.c = paramStoryVideoItem.mVid;
          }
          if ((localwmq.b == 0) || (TextUtils.isEmpty(localwmq.e))) {
            break label278;
          }
        }
        label273:
        label278:
        for (boolean bool = true;; bool = false)
        {
          a(bool);
          j();
          return;
          paramxhf = null;
          break;
          i = 0;
          break label196;
        }
      }
    }
    this.c = paramStoryVideoItem.mVid;
    k();
  }
  
  public boolean a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramxhf.a != null) && (paramxhf.a.jdField_a_of_type_Int == 13);
  }
  
  public int b()
  {
    return -1;
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Xpi != null) {
      b(this.jdField_a_of_type_Xpi);
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, new Object[] { "onClick ", Integer.valueOf(paramView.getId()), ", url=", paramView.getTag() });
      }
      Object localObject = paramView.getTag();
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        switch (paramView.getId())
        {
        }
        for (;;)
        {
          if (!((String)localObject).startsWith("mqqapi:")) {
            break label234;
          }
          localObject = bhey.a(QQStoryContext.a(), b(), (String)localObject);
          if (localObject == null) {
            break;
          }
          ((bheh)localObject).a();
          break;
          ykv.a("play_video", "clk_try", 0, 0, new String[] { localObject, "", "", this.c });
          continue;
          ykv.a("play_video", "clk_all_tips", 0, 0, new String[] { localObject, "", "", this.c });
        }
        label234:
        Intent localIntent = new Intent(b(), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        b().startActivity(localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xph
 * JD-Core Version:    0.7.0.1
 */