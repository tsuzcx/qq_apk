import android.graphics.Color;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow.b;
import java.util.Map;

public class uzi
  implements View.OnLongClickListener
{
  boolean Bw = false;
  albb jdField_a_of_type_Albb;
  BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = null;
  View.OnClickListener bu = new uzl(this);
  
  public uzi(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  void b(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      String str = paramTextView.getText().toString();
      int k = str.indexOf(paramString);
      int m = k + paramString.length();
      if ((k >= 0) && (m <= str.length()))
      {
        if ((paramTextView.getText() instanceof Spannable)) {}
        for (paramTextView = (Spannable)paramTextView.getText(); paramTextView != null; paramTextView = null)
        {
          int i;
          if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan == null) {
            i = 1714664933;
          }
          try
          {
            int j = Color.parseColor("#33000000");
            i = j;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
          this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(i);
          paramTextView.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, k, m, 17);
          return;
        }
      }
    }
  }
  
  void h(TextView paramTextView)
  {
    if (paramTextView == null) {}
    Spannable localSpannable;
    do
    {
      return;
      localSpannable = null;
      if ((paramTextView.getText() instanceof Spannable)) {
        localSpannable = (Spannable)paramTextView.getText();
      }
    } while (localSpannable == null);
    localSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
  }
  
  public boolean onLongClick(View paramView)
  {
    aqoa localaqoa = null;
    if ((this.Bw) || (paramView == null) || (!(paramView.getTag() instanceof albb))) {
      return false;
    }
    Object localObject1 = (albb)paramView.getTag();
    try
    {
      localMap = (Map)((albb)localObject1).data;
      this.jdField_a_of_type_Albb = ((albb)localObject1);
      switch (((albb)localObject1).nType)
      {
      default: 
        localObject1 = null;
        if ((localaqoa != null) && (localaqoa.size() > 0))
        {
          this.Bw = true;
          if (localMap == null) {
            break label449;
          }
        }
        break;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          if (localMap.containsKey("xoff")) {
            i = ((Integer)localMap.get("xoff")).intValue();
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            Map localMap;
            if (localMap.containsKey("yoff"))
            {
              j = ((Integer)localMap.get("yoff")).intValue();
              aqgq.a(paramView, i, j, localaqoa, this.bu, (BubblePopupWindow.b)localObject1);
              return true;
              localThrowable1 = localThrowable1;
              if (QLog.isColorLevel()) {
                QLog.d("FriendProfileCardActivity", 2, localThrowable1, new Object[0]);
              }
              Object localObject2 = null;
              continue;
              paramView.setSelected(true);
              localaqoa = new aqoa();
              localaqoa.Z(2131365509, this.this$0.getString(2131692330), 0);
              localObject1 = new uzj(this, paramView);
              continue;
              localaqoa = new aqoa();
              if ((this.jdField_a_of_type_Albb.data instanceof alas))
              {
                ((alas)this.jdField_a_of_type_Albb.data).e(localaqoa);
                if ((paramView instanceof TextView)) {
                  b((TextView)paramView, ((alas)this.jdField_a_of_type_Albb.data).mContent);
                }
                localObject1 = new uzk(this, paramView);
                continue;
              }
              if (!(this.jdField_a_of_type_Albb.data instanceof String)) {
                continue;
              }
              localaqoa.Z(2131365509, this.this$0.getString(2131692330), 0);
              if (!(paramView instanceof TextView)) {
                continue;
              }
              b((TextView)paramView, (String)this.jdField_a_of_type_Albb.data);
              continue;
              localThrowable2 = localThrowable2;
              i = 0;
              if (QLog.isColorLevel()) {
                QLog.d("FriendProfileCardActivity", 2, localThrowable2, new Object[0]);
              }
              j = 0;
              continue;
            }
          }
          catch (Throwable localThrowable3)
          {
            continue;
            j = 0;
            continue;
          }
          i = 0;
          continue;
        }
        label449:
        int j = 0;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzi
 * JD-Core Version:    0.7.0.1
 */