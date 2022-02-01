import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class anvl
  extends anqw
{
  public ArrayList<anvl.a> AU;
  public int cBa;
  public int dMN;
  public int mMax;
  
  public anvl()
  {
    this.mTypeName = "checklist";
    fK("12");
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Drawable localDrawable;
    int i;
    label75:
    int k;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131380601);
      paramView.setOrientation(1);
      if (this.AU == null) {
        break label320;
      }
      localDrawable = paramContext.getResources().getDrawable(2130851474);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (!TextUtils.isEmpty(this.chJ)) {
        break label184;
      }
      i = Kq();
      k = i / 2;
      if (this.AU.size() != paramView.getChildCount()) {
        break label196;
      }
      i = 1;
      label98:
      if ((i == 0) && (paramView.getChildCount() > 0)) {
        paramView.removeAllViews();
      }
      if (this.AU.size() <= 2) {
        break label202;
      }
    }
    int j;
    anvl.a locala;
    label184:
    label196:
    label202:
    for (paramBundle = this.AU.subList(0, 2);; paramBundle = this.AU)
    {
      j = 0;
      for (;;)
      {
        if (j >= paramBundle.size()) {
          break label320;
        }
        locala = (anvl.a)paramBundle.get(j);
        if (locala != null) {
          break;
        }
        j += 1;
      }
      paramView = (LinearLayout)paramView;
      break;
      i = Integer.parseInt(this.chJ);
      break label75;
      i = 0;
      break label98;
    }
    if (i != 0) {}
    for (TextView localTextView = (TextView)paramView.getChildAt(j);; localTextView = new TextView(paramContext))
    {
      localTextView.setSingleLine();
      localTextView.setEllipsize(a());
      localTextView.setGravity(16);
      localTextView.setTextSize(k);
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
      localTextView.setText(" " + locala.ciw);
      if (i != 0) {
        break;
      }
      paramView.addView(localTextView);
      break;
    }
    label320:
    paramView.setTag(this);
    return paramView;
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "checklist");
    paramXmlSerializer.attribute(null, "min", String.valueOf(this.cBa));
    paramXmlSerializer.attribute(null, "max", String.valueOf(this.mMax));
    if ((this.AU != null) && (!this.AU.isEmpty()))
    {
      int i = 0;
      if (i < this.AU.size())
      {
        anvl.a locala = (anvl.a)this.AU.get(i);
        if (locala != null)
        {
          paramXmlSerializer.startTag(null, locala.itemName);
          if (locala.ciw != null) {
            break label147;
          }
        }
        label147:
        for (String str = "";; str = locala.ciw)
        {
          paramXmlSerializer.attribute(null, "min", str);
          paramXmlSerializer.endTag(null, locala.itemName);
          i += 1;
          break;
        }
      }
    }
    paramXmlSerializer.endTag(null, "checklist");
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {}
    for (;;)
    {
      return true;
      Object localObject = paramansf.getAttribute("min");
      String str = paramansf.getAttribute("max");
      try
      {
        this.cBa = Integer.parseInt((String)localObject);
        this.mMax = Integer.parseInt(str);
        this.dMN = paramansf.Ks();
        this.AU = new ArrayList(this.dMN);
        int i = 0;
        while (i < this.dMN)
        {
          localObject = paramansf.a(i);
          if (localObject != null) {
            this.AU.add(new anvl.a((ansf)localObject));
          }
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  public String getLayoutStr()
  {
    return "Vote";
  }
  
  protected int getTextId()
  {
    return 2131381027;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.cBa = paramObjectInput.readInt();
    this.mMax = paramObjectInput.readInt();
    this.dMN = paramObjectInput.readInt();
    this.AU = new ArrayList(this.dMN);
    int i = 0;
    while (i < this.dMN)
    {
      String str1 = paramObjectInput.readUTF();
      String str2 = paramObjectInput.readUTF();
      this.AU.add(new anvl.a(str1, str2));
      i += 1;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.cBa);
    paramObjectOutput.writeInt(this.mMax);
    paramObjectOutput.writeInt(this.dMN);
    if ((this.AU != null) && (this.AU.size() == this.dMN))
    {
      int i = 0;
      if (i < this.dMN)
      {
        anvl.a locala = (anvl.a)this.AU.get(i);
        if (locala != null)
        {
          if (locala.itemName != null) {
            break label127;
          }
          str = "";
          label95:
          paramObjectOutput.writeUTF(str);
          if (locala.ciw != null) {
            break label136;
          }
        }
        label136:
        for (String str = "";; str = locala.ciw)
        {
          paramObjectOutput.writeUTF(str);
          i += 1;
          break;
          label127:
          str = locala.itemName;
          break label95;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("StructMsg", 2, "StructMsgItemVote writeExternal() mOptions is null, or size is error!");
    }
  }
  
  public class a
  {
    String ciw;
    String itemName;
    
    public a(ansf paramansf)
    {
      if (paramansf == null) {
        return;
      }
      this.itemName = paramansf.getAttribute("c");
      if (TextUtils.isEmpty(this.itemName)) {
        this.itemName = paramansf.getAttribute("r");
      }
      this.ciw = anbk.w(anre.a(paramansf), false);
    }
    
    public a(String paramString1, String paramString2)
    {
      this.itemName = paramString1;
      this.ciw = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvl
 * JD-Core Version:    0.7.0.1
 */