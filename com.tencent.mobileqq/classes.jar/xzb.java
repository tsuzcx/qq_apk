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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.presseffect.PressEffectTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class xzb
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private PressEffectTextView jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
  private xzc jdField_a_of_type_Xzc;
  private String c;
  
  public xzb(View paramView)
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
      ((LinearLayout.LayoutParams)localObject).bottomMargin = zps.a(localContext, f);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setPadding(zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F), zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 38.0F));
    localLayoutParams.bottomMargin = zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 4.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(1000);
    this.jdField_a_of_type_AndroidWidgetButton.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839304);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localLayoutParams = new RelativeLayout.LayoutParams(zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F), zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 40.0F));
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(2, 1001);
    localLayoutParams.bottomMargin = zps.a(this.jdField_a_of_type_AndroidViewView.getContext(), 10.0F);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    a(true);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Xzc = new xzc(this);
    a(this.jdField_a_of_type_Xzc);
  }
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject1 = null;
    if ((paramxqz.a == null) || (paramxqz.a.jdField_a_of_type_JavaUtilList == null) || (paramxqz.a.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.c = paramStoryVideoItem.mVid;
      k();
      return;
    }
    paramxqz = paramxqz.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramxqz.hasNext())
    {
      wwf localwwf = (wwf)paramxqz.next();
      if (TextUtils.equals(paramStoryVideoItem.mVid, localwwf.jdField_a_of_type_JavaLangString))
      {
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
        int i;
        if (localwwf.jdField_a_of_type_Int != 0)
        {
          paramxqz = localwwf.c;
          ((Button)localObject2).setText(paramxqz);
          this.jdField_a_of_type_AndroidWidgetButton.setTag(localwwf.d);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
          paramxqz = localObject1;
          if (localwwf.b != 0) {
            paramxqz = localwwf.e;
          }
          ((PressEffectTextView)localObject2).setText(paramxqz);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTag(localwwf.f);
          if ((localwwf.b == 0) || (TextUtils.isEmpty(localwwf.e))) {
            break label273;
          }
          i = 1;
          label196:
          if ((i != 0) && (!TextUtils.equals(this.c, paramStoryVideoItem.mVid)))
          {
            yup.a("play_video", "exp_all_tips", 0, 0, new String[0]);
            this.c = paramStoryVideoItem.mVid;
          }
          if ((localwwf.b == 0) || (TextUtils.isEmpty(localwwf.e))) {
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
          paramxqz = null;
          break;
          i = 0;
          break label196;
        }
      }
    }
    this.c = paramStoryVideoItem.mVid;
    k();
  }
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramxqz.a != null) && (paramxqz.a.jdField_a_of_type_Int == 13);
  }
  
  public int b()
  {
    return -1;
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Xzc != null) {
      b(this.jdField_a_of_type_Xzc);
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
          localObject = bhni.a(QQStoryContext.a(), b(), (String)localObject);
          if (localObject == null) {
            break;
          }
          ((bhmr)localObject).a();
          break;
          yup.a("play_video", "clk_try", 0, 0, new String[] { localObject, "", "", this.c });
          continue;
          yup.a("play_video", "clk_all_tips", 0, 0, new String[] { localObject, "", "", this.c });
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
 * Qualified Name:     xzb
 * JD-Core Version:    0.7.0.1
 */