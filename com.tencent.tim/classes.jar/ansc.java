import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class ansc
  extends anqu
{
  private String cib = "";
  public ArrayList<anqu> rz = new ArrayList();
  
  public ansc()
  {
    this.mTypeName = "taglist";
  }
  
  private LinearLayout b(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.setOrientation(0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131362459);
    if (AppSetting.enableTalkBack) {
      paramContext.setContentDescription(this.cib);
    }
    return paramContext;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = paramContext.getResources();
    int i;
    if (paramView != null)
    {
      paramBundle = paramView;
      if ((paramView instanceof LinearLayout))
      {
        localObject = (LinearLayout)paramView;
        i = 0;
        for (;;)
        {
          paramBundle = paramView;
          if (i >= this.rz.size()) {
            break;
          }
          ((anqu)this.rz.get(i)).a(paramContext, ((LinearLayout)localObject).getChildAt(i), null);
          i += 1;
        }
      }
    }
    else
    {
      paramView = b(paramContext);
      paramView.setPadding(wja.dp2px(12.0F, (Resources)localObject), 0, wja.dp2px(12.0F, (Resources)localObject), 0);
      i = 0;
      int j = 1;
      paramBundle = paramView;
      if (i < this.rz.size())
      {
        paramBundle = ((anqu)this.rz.get(i)).a(paramContext, null, null);
        if (j == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
          localLayoutParams.setMargins(wja.dp2px(2.0F, (Resources)localObject), 0, 0, 0);
          paramView.addView(paramBundle, localLayoutParams);
        }
        for (;;)
        {
          i += 1;
          break;
          paramView.addView(paramBundle);
          j = 0;
        }
      }
    }
    return paramBundle;
  }
  
  public void a(anqu paramanqu)
  {
    if ((paramanqu instanceof ansb)) {
      this.rz.add(paramanqu);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, this.mTypeName);
    Iterator localIterator = this.rz.iterator();
    while (localIterator.hasNext()) {
      ((anqu)localIterator.next()).a(paramXmlSerializer);
    }
    paramXmlSerializer.endTag(null, this.mTypeName);
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    int j = paramansf.Ks();
    int i = 0;
    label13:
    ansf localansf;
    if (i < j)
    {
      localansf = paramansf.a(i);
      if (localansf != null) {
        break label37;
      }
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label37:
      anqu localanqu = null;
      if ("tag".equals(localansf.name)) {
        localanqu = anrd.a(localansf.name);
      }
      if (localanqu == null) {
        return false;
      }
      if (!localanqu.a(localansf)) {
        break label89;
      }
      a(localanqu);
    }
    label89:
    return false;
  }
  
  public String getLayoutStr()
  {
    return "taglist";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      anqu localanqu = anrd.a(paramObjectInput.readUTF());
      if (localanqu != null)
      {
        localanqu.e = this.e;
        localanqu.readExternal(paramObjectInput);
        a(localanqu);
      }
      i += 1;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.rz.size());
    Iterator localIterator = this.rz.iterator();
    while (localIterator.hasNext()) {
      ((anqu)localIterator.next()).writeExternal(paramObjectOutput);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansc
 * JD-Core Version:    0.7.0.1
 */