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
import com.tribe.async.dispatch.Subscriber;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class uiu
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private PressEffectTextView jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
  private uiv jdField_a_of_type_Uiv;
  private String c;
  
  public uiu(View paramView)
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
      ((LinearLayout.LayoutParams)localObject).bottomMargin = vzl.a(localContext, f);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setPadding(vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F), vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 82.5F), vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 9.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 38.0F));
    localLayoutParams.bottomMargin = vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 4.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidWidgetButton.setId(1000);
    this.jdField_a_of_type_AndroidWidgetButton.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839039);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localLayoutParams = new RelativeLayout.LayoutParams(vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F), vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 40.0F));
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(2, 1001);
    localLayoutParams.bottomMargin = vzl.a(this.jdField_a_of_type_AndroidViewView.getContext(), 10.0F);
    ((RelativeLayout)paramView).addView(this.jdField_a_of_type_AndroidWidgetButton, localLayoutParams);
    a(true);
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Uiv = new uiv(this);
    a(this.jdField_a_of_type_Uiv);
  }
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    Object localObject1 = null;
    if ((paramuas.a == null) || (paramuas.a.jdField_a_of_type_JavaUtilList == null) || (paramuas.a.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.c = paramStoryVideoItem.mVid;
      k();
      return;
    }
    paramuas = paramuas.a.jdField_a_of_type_JavaUtilList.iterator();
    while (paramuas.hasNext())
    {
      tfx localtfx = (tfx)paramuas.next();
      if (TextUtils.equals(paramStoryVideoItem.mVid, localtfx.jdField_a_of_type_JavaLangString))
      {
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
        int i;
        if (localtfx.jdField_a_of_type_Int != 0)
        {
          paramuas = localtfx.c;
          ((Button)localObject2).setText(paramuas);
          this.jdField_a_of_type_AndroidWidgetButton.setTag(localtfx.d);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView;
          paramuas = localObject1;
          if (localtfx.b != 0) {
            paramuas = localtfx.e;
          }
          ((PressEffectTextView)localObject2).setText(paramuas);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectTextView.setTag(localtfx.f);
          if ((localtfx.b == 0) || (TextUtils.isEmpty(localtfx.e))) {
            break label273;
          }
          i = 1;
          label196:
          if ((i != 0) && (!TextUtils.equals(this.c, paramStoryVideoItem.mVid)))
          {
            vei.a("play_video", "exp_all_tips", 0, 0, new String[0]);
            this.c = paramStoryVideoItem.mVid;
          }
          if ((localtfx.b == 0) || (TextUtils.isEmpty(localtfx.e))) {
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
          paramuas = null;
          break;
          i = 0;
          break label196;
        }
      }
    }
    this.c = paramStoryVideoItem.mVid;
    k();
  }
  
  public boolean a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramuas.a != null) && (paramuas.a.jdField_a_of_type_Int == 13);
  }
  
  public int b()
  {
    return -1;
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Uiv != null) {
      b(this.jdField_a_of_type_Uiv);
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, new Object[] { "onClick ", Integer.valueOf(paramView.getId()), ", url=", paramView.getTag() });
      }
      localObject = paramView.getTag();
    } while (!(localObject instanceof String));
    Object localObject = (String)localObject;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (!((String)localObject).startsWith("mqqapi:")) {
        break label224;
      }
      paramView = bbex.a(QQStoryContext.a(), b(), (String)localObject);
      if (paramView == null) {
        break;
      }
      paramView.c();
      return;
      vei.a("play_video", "clk_try", 0, 0, new String[] { localObject, "", "", this.c });
      continue;
      vei.a("play_video", "clk_all_tips", 0, 0, new String[] { localObject, "", "", this.c });
    }
    label224:
    paramView = new Intent(b(), QQBrowserActivity.class);
    paramView.putExtra("url", (String)localObject);
    b().startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiu
 * JD-Core Version:    0.7.0.1
 */