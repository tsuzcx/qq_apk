import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;

public class aawl
  extends aavx<TextPreviewTranslateActivity>
{
  protected void a(ContainerView paramContainerView)
  {
    super.a(paramContainerView);
    TextPreviewTranslateActivity localTextPreviewTranslateActivity = (TextPreviewTranslateActivity)this.mActivity.get();
    if (localTextPreviewTranslateActivity != null) {
      paramContainerView.setOutScrollView((ScrollView)localTextPreviewTranslateActivity.findViewById(2131377758));
    }
    paramContainerView.cZS = false;
    paramContainerView.e.post(new TranslateSelectableMenu.1(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    super.a(paramContainerView, paramView);
    anot.a((QQAppInterface)this.n.get(), "dc00898", "", "", "0X800A435", "0X800A435", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((paramView.getId() != 2131377931) && (aavp.a().isSelected())) {
        aavp.a().detach();
      }
      for (;;)
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          try
          {
            aofz.hG(getContent(), "TextPreview");
            anot.a((QQAppInterface)this.n.get(), "dc00898", "", "", "0X800A437", "0X800A437", 0, 0, "", "", "", "");
          }
          catch (Exception localException) {}
        }
        if (QLog.isColorLevel()) {
          QLog.e("TranslateSelectableMenu", 2, localException.toString());
        }
      }
      aofz.N((Activity)paramView.getContext(), getContent());
      anot.a((QQAppInterface)this.n.get(), "dc00898", "", "", "0X800A438", "0X800A438", 0, 0, "", "", "", "");
      continue;
      if (localException != null) {
        aofz.c((Activity)paramView.getContext(), localException, getContent());
      }
      anot.a((QQAppInterface)this.n.get(), "dc00898", "", "", "0X800A439", "0X800A439", 0, 0, "", "", "", "");
      continue;
      aavp.a().O(null);
      anot.a((QQAppInterface)this.n.get(), "dc00898", "", "", "0X800A436", "0X800A436", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawl
 * JD-Core Version:    0.7.0.1
 */