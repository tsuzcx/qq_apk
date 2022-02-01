import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class anvd
  extends anqu
{
  public int bottomMargin = this.topMargin;
  public boolean cJR;
  private int mLayoutMode;
  public final ArrayList<anqu> rz = new ArrayList();
  public int topMargin = wja.dp2px(2.5F, BaseApplicationImpl.getContext().getResources());
  
  public anvd()
  {
    this.mTypeName = "tr";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    label30:
    Object localObject;
    if (!this.cJR)
    {
      int i;
      anuy localanuy;
      View localView;
      int j;
      if ((paramView != null) && ((paramView instanceof ViewGroup)))
      {
        paramView = (ViewGroup)paramView;
        paramView.removeAllViews();
        i = 0;
        localObject = paramView;
        if (i >= this.rz.size()) {
          break label195;
        }
        localObject = (anqu)this.rz.get(i);
        if ((localObject instanceof anuy))
        {
          localanuy = (anuy)localObject;
          localView = localanuy.a(paramContext, null, paramBundle);
          if ((localView instanceof TextView))
          {
            if (localanuy.weight != 0) {
              break label167;
            }
            j = 1;
            label103:
            if (this.mLayoutMode == 1) {
              break label177;
            }
          }
        }
      }
      label167:
      label177:
      for (localObject = new LinearLayout.LayoutParams(0, -1, j);; localObject = new LinearLayout.LayoutParams(-2, -1))
      {
        ((TextView)localView).setGravity(localanuy.bkg);
        paramView.addView(localView, (ViewGroup.LayoutParams)localObject);
        i += 1;
        break label30;
        paramView = new LinearLayout(paramContext);
        break;
        j = localanuy.weight;
        break label103;
      }
    }
    else
    {
      localObject = null;
    }
    label195:
    return localObject;
  }
  
  void a(anqu paramanqu)
  {
    this.rz.add(paramanqu);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "tr");
    paramXmlSerializer.endTag(null, "tr");
  }
  
  public boolean a(ansf paramansf)
  {
    boolean bool2 = false;
    Object localObject1 = paramansf.getAttribute("mode");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    boolean bool1;
    try
    {
      this.mLayoutMode = Integer.valueOf((String)localObject1).intValue();
      localObject1 = paramansf.getAttribute("margin");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        if ((localObject1 == null) || (localObject1.length < 2)) {}
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        do
        {
          Object localObject2 = BaseApplicationImpl.getContext().getResources();
          this.topMargin = wja.dp2px(Float.valueOf(localObject1[0]).floatValue(), (Resources)localObject2);
          this.bottomMargin = wja.dp2px(Float.valueOf(localObject1[1]).floatValue(), (Resources)localObject2);
          localObject1 = paramansf.getAttribute("hidden");
          if ((localObject1 != null) && (((String)localObject1).toLowerCase().equals("true"))) {
            this.cJR = true;
          }
          int i = 0;
          while (i < paramansf.Ks())
          {
            localObject1 = paramansf.a(i);
            if ((localObject1 != null) && ("td".equals(((ansf)localObject1).name)))
            {
              localObject2 = anrd.a(((ansf)localObject1).name);
              bool1 = bool2;
              if (localObject2 == null) {
                return bool1;
              }
              bool1 = bool2;
              if (!((anqu)localObject2).a((ansf)localObject1)) {
                return bool1;
              }
              a((anqu)localObject2);
            }
            i += 1;
          }
          localNumberFormatException1 = localNumberFormatException1;
        } while (!QLog.isColorLevel());
        QLog.w("StructMsgItemTr", 2, "mode must be a numeric ", localNumberFormatException1);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("StructMsgItemTr", 2, "h must be a numeric ", localNumberFormatException2);
          }
          this.topMargin = 0;
          this.bottomMargin = 0;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getLayoutStr()
  {
    return "tr";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.mLayoutMode = paramObjectInput.readInt();
    this.topMargin = paramObjectInput.readInt();
    this.bottomMargin = paramObjectInput.readInt();
    int j = paramObjectInput.readInt();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.cJR = true;
    }
    int i = 0;
    while (i < j)
    {
      localObject = paramObjectInput.readUTF();
      if ("td".equals(localObject))
      {
        localObject = anrd.a((String)localObject);
        if (localObject != null)
        {
          ((anqu)localObject).readExternal(paramObjectInput);
          a((anqu)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.mLayoutMode);
    paramObjectOutput.writeInt(this.topMargin);
    paramObjectOutput.writeInt(this.bottomMargin);
    paramObjectOutput.writeInt(this.rz.size());
    if (this.cJR) {}
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      localObject = this.rz.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anqu)((Iterator)localObject).next()).writeExternal(paramObjectOutput);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvd
 * JD-Core Version:    0.7.0.1
 */