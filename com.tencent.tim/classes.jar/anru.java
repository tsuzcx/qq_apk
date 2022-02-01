import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class anru
  extends anqu
{
  private SparseArray<View> db = new SparseArray();
  View.OnClickListener fN = new anrv(this);
  private ViewGroup mRootView;
  public List<anqu> uh = new ArrayList();
  
  public anru()
  {
    this.mTypeName = "group";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int j;
    int i;
    label62:
    Object localObject;
    View localView;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.mRootView = ((ViewGroup)paramView);
      this.mRootView.removeAllViews();
      this.db.clear();
      ((LinearLayout)this.mRootView).setOrientation(1);
      ((LinearLayout)this.mRootView).setGravity(16);
      j = 0;
      i = 1;
      if (j >= this.uh.size()) {
        break label499;
      }
      paramView = (anqu)this.uh.get(j);
      localObject = paramView.mTypeName;
      if (!"groupitem".equals(localObject)) {
        break label253;
      }
      localObject = paramView.a(paramContext, null, paramBundle);
      localView = ((View)localObject).findViewById(2131378841);
      if (localView != null)
      {
        if ((LinearLayout)((View)localObject).findViewById(2131378842) != null) {
          break label231;
        }
        localView.setOnClickListener(paramView);
        localView.setTag(paramView);
      }
      label155:
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.leftMargin = 0;
      paramView.rightMargin = 0;
      paramView.topMargin = 0;
      paramView.bottomMargin = 0;
      this.mRootView.addView((View)localObject, paramView);
      this.db.append(j, localObject);
    }
    for (;;)
    {
      j += 1;
      break label62;
      this.mRootView = new LinearLayout(paramContext);
      break;
      label231:
      localView.setOnClickListener(this.fN);
      localView.setTag(Integer.valueOf(j));
      break label155;
      label253:
      if ("hr".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        if (i != 0)
        {
          this.mRootView.addView(paramView, 0, (ViewGroup.LayoutParams)localObject);
          i = 0;
        }
        for (;;)
        {
          break;
          this.mRootView.addView(paramView, (ViewGroup.LayoutParams)localObject);
        }
      }
      if ("title".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, wja.dp2px(50.0F, paramContext.getResources()));
        ((TextView)paramView).setGravity(16);
        ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(12.0F, paramContext.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        this.mRootView.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
      else if ("item".equals(localObject))
      {
        paramView = paramView.a(paramContext, null, paramBundle);
        localObject = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
        this.mRootView.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
    }
    label499:
    return this.mRootView;
  }
  
  void a(anqu paramanqu)
  {
    this.uh.add(paramanqu);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "group");
    paramXmlSerializer.endTag(null, "group");
  }
  
  public boolean a(ansf paramansf)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramansf == null)
    {
      bool1 = true;
      return bool1;
    }
    int k = paramansf.Ks();
    int i = 0;
    while (i < k)
    {
      ansf localansf = paramansf.a(i);
      if (localansf == null)
      {
        label39:
        i += 1;
      }
      else
      {
        if ("item".equals(localansf.name)) {}
        for (Object localObject = localansf.getAttribute("layout");; localObject = anrd.a(localansf.name))
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject)) {}
            for (int j = Integer.parseInt((String)localObject);; j = 0)
            {
              localObject = anrd.a(j);
              bool1 = bool2;
              if (localObject == null) {
                break;
              }
              bool1 = bool2;
              if (!((anqu)localObject).a(localansf)) {
                break;
              }
              a((anqu)localObject);
              break label39;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (NumberFormatException paramansf)
          {
            bool1 = bool2;
          }
          QLog.i("StructMsgGroupElement", 2, "Item layout value is " + 0);
          return false;
        }
      }
    }
    return true;
  }
  
  public String getLayoutStr()
  {
    return "group";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    int m = paramObjectInput.readInt();
    int i = 1;
    int k = 0;
    if (k < m)
    {
      String str = paramObjectInput.readUTF();
      Object localObject;
      if ("item".equals(str)) {
        localObject = anrd.a(paramObjectInput.readInt());
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((anqu)localObject).e = this.e;
          ((anqu)localObject).readExternal(paramObjectInput);
          if (("groupitem".equals(str)) || ("hr".equals(str)) || ("title".equals(str)) || ("item".equals(str))) {
            a((anqu)localObject);
          }
        }
        k += 1;
        break;
        anqu localanqu = anrd.a(str);
        int j = i;
        if ("button".equals(str))
        {
          localanqu.chH = String.valueOf(i);
          localanqu.uin = this.uin;
          j = i + 1;
        }
        localObject = localanqu;
        i = j;
        if (localanqu != null)
        {
          localObject = localanqu;
          i = j;
          if (anqv.class.isInstance(localanqu))
          {
            paramObjectInput.readInt();
            localObject = localanqu;
            i = j;
          }
        }
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.uh.size());
    Iterator localIterator = this.uh.iterator();
    while (localIterator.hasNext()) {
      ((anqu)localIterator.next()).writeExternal(paramObjectOutput);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anru
 * JD-Core Version:    0.7.0.1
 */