import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlSerializer;

public class anrw
  extends anqu
{
  boolean cJL = false;
  int dMm;
  Context mContext = null;
  long mDuration = 0L;
  ViewGroup mRootView = null;
  boolean mUseAnimation = true;
  List<anqu> uh = null;
  
  public anrw()
  {
    this.mTypeName = "groupitem";
  }
  
  private void a(Resources paramResources, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (this.dMm == 0)
    {
      paramImageView.setBackgroundDrawable(null);
      return;
    }
    if (this.cJL)
    {
      paramImageView.setBackgroundResource(2130845300);
      return;
    }
    paramImageView.setBackgroundResource(2130845299);
  }
  
  private View j(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramView.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    Object localObject = new ImageView(paramView.getContext());
    ((ImageView)localObject).setImageResource(2130845301);
    int i = wja.dp2px(9.0F, paramView.getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(wja.dp2px(8.0F, paramView.getResources()), i);
    localLayoutParams.leftMargin = wja.dp2px(24.0F, paramView.getResources());
    localLayoutParams.rightMargin = wja.dp2px(4.0F, paramView.getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramView.setPadding(0, 0, 0, 0);
    localObject = paramView.findViewById(2131380951);
    if (localObject != null) {
      ((View)localObject).setPadding(0, ((View)localObject).getPaddingTop(), 0, ((View)localObject).getPaddingBottom());
    }
    localLinearLayout.addView(paramView);
    return localLinearLayout;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources;
    int i;
    label51:
    Object localObject2;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.mRootView = ((ViewGroup)paramView);
      this.mRootView.removeAllViews();
      this.mContext = paramContext;
      ((LinearLayout)this.mRootView).setOrientation(1);
      localResources = paramContext.getResources();
      i = 0;
      if (i >= this.uh.size()) {
        break label655;
      }
      localObject2 = (anqu)this.uh.get(i);
      paramView = ((anqu)localObject2).mTypeName;
      if (!"summary".equals(paramView)) {
        break label334;
      }
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131378841);
      paramView.setOrientation(0);
      localObject1 = new LinearLayout.LayoutParams(-1, wja.dp2px(42.0F, localResources));
      ((LinearLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(13.0F, localResources);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = wja.dp2px(13.0F, localResources);
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      localObject3 = (LinearLayout)this.mRootView.findViewById(2131378842);
      if (localObject3 != null) {
        break label323;
      }
      this.mRootView.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      label198:
      localObject1 = ((anqu)localObject2).a(paramContext, null, paramBundle);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131378840);
      a(localResources, (ImageView)localObject1);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.addView((View)localObject1);
    }
    label323:
    label334:
    do
    {
      for (;;)
      {
        i += 1;
        break label51;
        this.mRootView = new LinearLayout(paramContext);
        break;
        ((LinearLayout)localObject3).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        break label198;
        if (!"hr".equals(paramView)) {
          break label430;
        }
        paramView = ((anqu)localObject2).a(paramContext, null, paramBundle);
        localObject1 = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        localObject2 = (LinearLayout)this.mRootView.findViewById(2131378842);
        if (localObject2 == null) {
          this.mRootView.addView(paramView, (ViewGroup.LayoutParams)localObject1);
        } else {
          ((LinearLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        }
      }
    } while (!"item".equals(paramView));
    label430:
    Object localObject1 = (LinearLayout)this.mRootView.findViewById(2131378842);
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      paramView.setId(2131378842);
      if (!this.cJL) {
        break label646;
      }
      paramView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      paramView.setGravity(16);
      paramView.setBackgroundColor(localResources.getColor(2131167471));
      ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.mRootView.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject3 = ((anqu)localObject2).a(paramContext, null, paramBundle);
      localObject1 = j((View)localObject3);
      ((View)localObject3).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      ((View)localObject1).setTag(localObject2);
      localObject2 = new LinearLayout.LayoutParams(-1, wja.dp2px(48.0F, localResources));
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.dMm += 1;
      break;
      label646:
      paramView.setVisibility(8);
    }
    label655:
    return this.mRootView;
  }
  
  void a(anqu paramanqu)
  {
    this.uh.add(paramanqu);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "groupitem");
    if (!TextUtils.isEmpty(this.cgX)) {
      paramXmlSerializer.attribute(null, "action", this.cgX);
    }
    if (!TextUtils.isEmpty(this.cgY)) {
      paramXmlSerializer.attribute(null, "actionData", this.cgY);
    }
    if (!TextUtils.isEmpty(this.cgZ)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.cgZ);
    }
    if (!TextUtils.isEmpty(this.cha)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.cha);
    }
    if (!TextUtils.isEmpty(this.ku)) {
      paramXmlSerializer.attribute(null, "url", this.ku);
    }
    if (this.cJL)
    {
      str = "true";
      paramXmlSerializer.attribute(null, "expand", str);
      if (!this.mUseAnimation) {
        break label216;
      }
    }
    label216:
    for (String str = "true";; str = "false")
    {
      paramXmlSerializer.attribute(null, "expand", str);
      paramXmlSerializer.attribute(null, "expand", String.valueOf(this.mDuration));
      paramXmlSerializer.endTag(null, "groupitem");
      return;
      str = "false";
      break;
    }
  }
  
  public boolean a(ansf paramansf)
  {
    boolean bool = false;
    if (paramansf == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      this.cgX = paramansf.getAttribute("action");
      this.cgY = paramansf.getAttribute("actionData");
      this.cgZ = paramansf.getAttribute("a_actionData");
      this.cha = paramansf.getAttribute("i_actionData");
      this.ku = paramansf.getAttribute("url");
      this.dMm = 0;
      Object localObject = paramansf.getAttribute("expand");
      if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
        this.cJL = true;
      }
      localObject = paramansf.getAttribute("animation");
      if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
        this.mUseAnimation = false;
      }
      localObject = paramansf.getAttribute("duration");
      if (localObject != null) {}
      try
      {
        this.mDuration = Long.parseLong((String)localObject);
        label158:
        if ((paramansf.children != null) && (paramansf.Ks() > 0))
        {
          Iterator localIterator = paramansf.children.iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            ansf localansf = (ansf)localIterator.next();
            if (("summary".equals(localansf.name)) || ("hr".equals(localansf.name))) {
              paramansf = anrd.a(localansf.name);
            }
            do
            {
              localObject = paramansf;
              if (paramansf == null) {
                break;
              }
              localObject = paramansf;
              if (!paramansf.a(localansf)) {
                break;
              }
              a(paramansf);
              localObject = paramansf;
              break;
              paramansf = (ansf)localObject;
            } while (!"item".equals(localansf.name));
            paramansf = localansf.getAttribute("layout");
            try
            {
              if (!TextUtils.isEmpty(paramansf)) {}
              for (int i = Integer.parseInt(paramansf);; i = 0)
              {
                paramansf = anrd.a(i);
                this.dMm += 1;
                break;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (NumberFormatException paramansf) {}
            QLog.i("StructMsg", 2, "Item layout value is " + 0);
            return false;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        break label158;
      }
    }
  }
  
  public void dTv()
  {
    if (this.mRootView == null) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      localLinearLayout = (LinearLayout)this.mRootView.findViewById(2131378842);
    } while (localLinearLayout == null);
    localLinearLayout.setVisibility(8);
    this.cJL = false;
    a(this.mContext.getResources(), (ImageView)this.mRootView.findViewById(2131378840));
  }
  
  public String getLayoutStr()
  {
    return "groupitem";
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    int i = 1;
    super.readExternal(paramObjectInput);
    this.ku = paramObjectInput.readUTF();
    this.cgX = paramObjectInput.readUTF();
    this.cgY = paramObjectInput.readUTF();
    this.cgZ = paramObjectInput.readUTF();
    this.cha = paramObjectInput.readUTF();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.cJL = true;
    }
    localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
      this.mUseAnimation = false;
    }
    this.mDuration = paramObjectInput.readLong();
    int m = paramObjectInput.readInt();
    this.dMm = 0;
    int k = 0;
    if (k < m)
    {
      localObject = paramObjectInput.readUTF();
      if ("item".equals(localObject))
      {
        localObject = anrd.a(paramObjectInput.readInt());
        this.dMm += 1;
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((anqu)localObject).e = this.e;
          ((anqu)localObject).readExternal(paramObjectInput);
          a((anqu)localObject);
        }
        k += 1;
        break;
        anqu localanqu = anrd.a((String)localObject);
        int j = i;
        if ("button".equals(localObject))
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
  
  public void toggle()
  {
    if (this.mRootView == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayout)this.mRootView.findViewById(2131378842);
    } while (localObject1 == null);
    Object localObject2;
    if (this.cJL)
    {
      if (this.mUseAnimation)
      {
        localObject2 = new anrw.b((ViewGroup)localObject1);
        ((anrw.b)localObject2).setDuration(this.mDuration);
        ((anrw.b)localObject2).setInterpolator(new DecelerateInterpolator());
        ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
      }
      for (;;)
      {
        this.cJL = false;
        a(this.mContext.getResources(), (ImageView)this.mRootView.findViewById(2131378840));
        if (!(this.mContext instanceof FragmentActivity)) {
          break;
        }
        Object localObject3 = ((FragmentActivity)this.mContext).getChatFragment().getApp();
        if ((localObject3 == null) || (TextUtils.isEmpty(this.cgY))) {
          break;
        }
        localObject2 = "";
        Matcher localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(this.cgY);
        do
        {
          localObject1 = localObject2;
          if (!localMatcher.find()) {
            break;
          }
        } while (!"QidianKfUin".equals(localMatcher.group(1)));
        localObject1 = localMatcher.group(2);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject2 = (ashy)((QQAppInterface)localObject3).getBusinessHandler(85);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.cgY).append("&expand=").append(this.cJL);
        ((ashy)localObject2).b(((StringBuilder)localObject3).toString(), 1, false, 0.0D, 0.0D, (String)localObject1, 1, "", "", "");
        return;
        ((LinearLayout)localObject1).setVisibility(8);
      }
    }
    if (this.mUseAnimation)
    {
      localObject2 = new anrw.a((ViewGroup)localObject1);
      ((anrw.a)localObject2).setDuration(this.mDuration);
      ((anrw.a)localObject2).setInterpolator(new AccelerateInterpolator());
      ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
    }
    for (;;)
    {
      this.cJL = true;
      break;
      ((LinearLayout)localObject1).setVisibility(0);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    if (this.ku == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cgX != null) {
        break label199;
      }
      localObject = "";
      label34:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cgY != null) {
        break label207;
      }
      localObject = "";
      label52:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cgZ != null) {
        break label215;
      }
      localObject = "";
      label70:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.cha != null) {
        break label223;
      }
      localObject = "";
      label88:
      paramObjectOutput.writeUTF((String)localObject);
      if (!this.cJL) {
        break label231;
      }
      localObject = "true";
      label106:
      paramObjectOutput.writeUTF((String)localObject);
      if (!this.mUseAnimation) {
        break label238;
      }
    }
    label199:
    label207:
    label215:
    label223:
    label231:
    label238:
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mDuration);
      paramObjectOutput.writeInt(this.uh.size());
      localObject = this.uh.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anqu)((Iterator)localObject).next()).writeExternal(paramObjectOutput);
      }
      localObject = this.ku;
      break;
      localObject = this.cgX;
      break label34;
      localObject = this.cgY;
      break label52;
      localObject = this.cgZ;
      break label70;
      localObject = this.cha;
      break label88;
      localObject = "false";
      break label106;
    }
  }
  
  public static class a
    extends Animation
  {
    ViewGroup cB;
    int mHeight;
    
    public a(ViewGroup paramViewGroup)
    {
      this.cB = paramViewGroup;
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.cB.measure(i, j);
      this.mHeight = this.cB.getMeasuredHeight();
      paramViewGroup = (LinearLayout.LayoutParams)this.cB.getLayoutParams();
      paramViewGroup.height = 0;
      this.cB.setLayoutParams(paramViewGroup);
      this.cB.setVisibility(0);
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = (LinearLayout.LayoutParams)this.cB.getLayoutParams();
      paramTransformation.height = ((int)(this.mHeight * paramFloat));
      this.cB.setLayoutParams(paramTransformation);
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
  
  public static class b
    extends Animation
  {
    ViewGroup cB;
    int mHeight;
    
    public b(ViewGroup paramViewGroup)
    {
      this.cB = paramViewGroup;
      this.mHeight = this.cB.getHeight();
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = (LinearLayout.LayoutParams)this.cB.getLayoutParams();
      paramTransformation.height = ((int)(this.mHeight * (1.0F - paramFloat)));
      this.cB.setLayoutParams(paramTransformation);
      if (paramFloat == 1.0F)
      {
        this.cB.setVisibility(8);
        paramTransformation.height = this.mHeight;
        this.cB.setLayoutParams(paramTransformation);
      }
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrw
 * JD-Core Version:    0.7.0.1
 */