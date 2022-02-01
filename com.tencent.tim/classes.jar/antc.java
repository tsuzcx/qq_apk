import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class antc
  extends anqv
{
  protected String itemBgColor;
  
  private void a(Context paramContext, anqu paramanqu, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    paramanqu = (ansr)paramanqu;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "logo url = " + paramanqu.aNt);
    }
    if (TextUtils.isEmpty(paramanqu.aNt)) {
      return;
    }
    try
    {
      new URL(paramanqu.aNt);
      paramBundle = paramContext.getResources();
      int i = wja.dp2px(44.0F, paramBundle);
      paramContext = new URLImageView(paramContext);
      paramContext.setAdjustViewBounds(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, wja.dp2px(16.0F, paramBundle), wja.dp2px(18.0F, paramBundle), wja.dp2px(14.0F, paramBundle));
      localLayoutParams.addRule(11);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      paramContext.setLayoutParams(localLayoutParams);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = i;
      paramBundle.mRequestHeight = i;
      paramanqu = URLDrawable.getDrawable(paramanqu.aNt, paramBundle);
      paramanqu.setAutoDownload(true);
      if (paramanqu.getStatus() == 2) {
        paramanqu.restartDownload();
      }
      paramContext.setImageDrawable(paramanqu);
      paramContext.setId(2131378830);
      paramViewGroup.addView(paramContext);
      return;
    }
    catch (MalformedURLException paramContext) {}
  }
  
  private void a(Context paramContext, anqu paramanqu, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)paramanqu.a(paramContext, null, paramBundle);
    paramanqu = new RelativeLayout.LayoutParams(-2, -2);
    paramanqu.setMargins(wja.dp2px(19.0F, localResources), wja.dp2px(4.5F, localResources), 0, 0);
    paramanqu.addRule(3, 2131378831);
    if (paramBoolean)
    {
      paramanqu.addRule(0, 2131378830);
      paramanqu.addRule(9);
    }
    paramContext.setLayoutParams(paramanqu);
    paramContext.setSingleLine();
    paramViewGroup.addView(paramContext);
  }
  
  private void a(Context paramContext, anqu paramanqu, Bundle paramBundle, QQWalletTransferBubbleView paramQQWalletTransferBubbleView)
  {
    try
    {
      i = Color.parseColor(((anuw)paramanqu).Av());
      paramQQWalletTransferBubbleView.setBubbleBackground(2130848115, i, true);
      Resources localResources = paramContext.getResources();
      paramContext = (TextView)paramanqu.a(paramContext, null, paramBundle);
      paramanqu = new RelativeLayout.LayoutParams(-2, -2);
      paramanqu.setMargins(wja.dp2px(19.0F, localResources), 0, 0, 0);
      paramanqu.addRule(15);
      paramContext.setLayoutParams(paramanqu);
      paramQQWalletTransferBubbleView.addView(paramContext);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = Color.parseColor("#ffffff");
      }
    }
  }
  
  private void b(Context paramContext, anqu paramanqu, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)paramanqu.a(paramContext, null, paramBundle);
    paramanqu = new RelativeLayout.LayoutParams(-2, -2);
    paramanqu.setMargins(wja.dp2px(19.0F, localResources), wja.dp2px(11.0F, localResources), 0, 0);
    if (paramBoolean)
    {
      paramanqu.addRule(0, 2131378830);
      paramanqu.addRule(9);
    }
    paramContext.setLayoutParams(paramanqu);
    paramContext.setSingleLine();
    paramContext.setId(2131378831);
    paramViewGroup.addView(paramContext);
  }
  
  protected int IX()
  {
    return 19;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "to xml");
    }
    if (!TextUtils.isEmpty(this.itemBgColor)) {
      paramXmlSerializer.attribute(null, "url", this.itemBgColor);
    }
    super.a(paramXmlSerializer);
  }
  
  public boolean a(ansf paramansf)
  {
    boolean bool = super.a(paramansf);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "from xml");
    }
    this.itemBgColor = paramansf.getAttribute("bgColor");
    return bool;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    for (;;)
    {
      Object localObject2 = new QQWalletTransferBubbleView(paramContext);
      ((QQWalletTransferBubbleView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, wja.dp2px(74.0F, (Resources)localObject1)));
      try
      {
        i = Color.parseColor(this.itemBgColor);
        ((QQWalletTransferBubbleView)localObject2).setBubbleBackground(2130848114, i, true);
        paramView.addView((View)localObject2);
        QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
        localQQWalletTransferBubbleView.setLayoutParams(new LinearLayout.LayoutParams(-1, wja.dp2px(25.0F, (Resources)localObject1)));
        paramView.addView(localQQWalletTransferBubbleView);
        localObject1 = this.rz.iterator();
        bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          anqu localanqu = (anqu)((Iterator)localObject1).next();
          if ((localanqu instanceof ansr))
          {
            a(paramContext, localanqu, paramBundle, (ViewGroup)localObject2);
            bool = true;
            continue;
            paramView = new LinearLayout(paramContext);
            paramView.setOrientation(1);
            paramView.setGravity(1);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, wja.dp2px(3.0F, (Resources)localObject1), 0, 0);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramView.setId(2131378829);
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "parse item bg color failure, color = " + this.itemBgColor);
          }
          i = Color.parseColor("#18b4ed");
        }
        int j = this.rz.size();
        int i = 0;
        if (i < j)
        {
          localObject1 = (anqu)this.rz.get(i);
          if ((localObject1 instanceof StructMsgItemTitle)) {
            b(paramContext, (anqu)localObject1, paramBundle, (ViewGroup)localObject2, bool);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject1 instanceof anux)) {
              a(paramContext, (anqu)localObject1, paramBundle, (ViewGroup)localObject2, bool);
            } else if ((localObject1 instanceof anuw)) {
              a(paramContext, (anqu)localObject1, paramBundle, localException);
            }
          }
        }
      }
    }
    return paramView;
  }
  
  public String getName()
  {
    return "Layout19";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "read external");
    }
    super.readExternal(paramObjectInput);
    this.itemBgColor = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "write external");
    }
    super.writeExternal(paramObjectOutput);
    if (this.itemBgColor == null) {}
    for (String str = "";; str = this.itemBgColor)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antc
 * JD-Core Version:    0.7.0.1
 */