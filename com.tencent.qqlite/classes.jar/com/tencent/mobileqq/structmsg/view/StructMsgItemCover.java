package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import efi;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemCover
  extends AbsStructMsgElement
{
  private URLDrawableDownListener.Adapter a;
  String h;
  
  public StructMsgItemCover()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new efi(this);
    this.jdField_a_of_type_JavaLangString = "picture";
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.h = paramString;
  }
  
  public View a(Context paramContext, View paramView)
  {
    Object localObject1 = paramContext.getResources();
    Object localObject3;
    Object localObject2;
    try
    {
      Drawable localDrawable = ((Resources)localObject1).getDrawable(2130839400);
      if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView)))
      {
        localObject3 = (AnyScaleTypeImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject3;
        paramView.setTag(this);
        localObject3 = this.h;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label119;
        }
        paramView.setImageDrawable(localDrawable);
        paramView.setBackgroundColor(15790320);
        return localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localObject2 = null;
        continue;
        paramView = new AnyScaleTypeImageView(paramContext);
        paramView.setId(2131296323);
        paramView.setContentDescription(((Resources)localObject1).getString(2131362823));
        paramView.setDisplayRuleDef(CustomScaleType.CENTER_SMALL_SCALE_BIG_RULE);
        localObject1 = paramView;
      }
      label119:
      if (((String)localObject3).startsWith("http://")) {
        break label193;
      }
    }
    if (!((String)localObject3).startsWith("https://")) {}
    for (;;)
    {
      try
      {
        paramContext = URLDrawable.getDrawable(new File((String)localObject3).toURL().toString(), (Drawable)localObject2, (Drawable)localObject2);
        if ((paramContext == null) || (paramContext.getStatus() != 1)) {
          break label238;
        }
        paramView.setBackgroundDrawable(null);
        paramView.setImageDrawable(paramContext);
        return localObject1;
      }
      catch (MalformedURLException paramContext)
      {
        paramContext = null;
        continue;
      }
      label193:
      localObject2 = URLDrawable.getDrawable((String)localObject3, (Drawable)localObject2, (Drawable)localObject2);
      if ((AbsDownloader.a((String)localObject3)) || (!URLDrawableHelper.a(paramContext))) {}
      for (boolean bool = true;; bool = false)
      {
        ((URLDrawable)localObject2).setAutoDownload(bool);
        paramContext = (Context)localObject2;
        break;
      }
      label238:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundColor(15790320);
    }
  }
  
  public String a()
  {
    return "Cover";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.h = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.h == null) {}
    for (String str = "";; str = this.h)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.h == null) {}
    for (String str = "";; str = this.h)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    paramStructMsgNode = paramStructMsgNode.a("cover");
    if (paramStructMsgNode != null) {}
    for (;;)
    {
      this.h = paramStructMsgNode;
      return true;
      paramStructMsgNode = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover
 * JD-Core Version:    0.7.0.1
 */