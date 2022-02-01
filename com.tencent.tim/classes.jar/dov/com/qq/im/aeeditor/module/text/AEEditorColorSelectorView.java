package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import axnp;
import axnq;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class AEEditorColorSelectorView
  extends FrameLayout
{
  private axnq a;
  private final LinkedHashMap<Integer, ImageView> ao = new LinkedHashMap();
  private final int eGf = Color.parseColor("#ffffffff");
  private final int eGg = Color.parseColor("#ff2b2b2b");
  private final int eGh = Color.parseColor("#fffb5151");
  private final int eGi = Color.parseColor("#ffffc300");
  private final int eGj = Color.parseColor("#ff07c160");
  private final int eGk = Color.parseColor("#ff0faeff");
  private final int eGl = Color.parseColor("#ff5d5ad7");
  
  public AEEditorColorSelectorView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Drawable a(boolean paramBoolean, int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    int i;
    int k;
    if (paramBoolean)
    {
      i = 2131299588;
      k = getResources().getDimensionPixelSize(2131299585);
      if (!paramBoolean) {
        break label85;
      }
    }
    label85:
    for (int j = 0;; j = getResources().getDimensionPixelSize(2131299589))
    {
      j = k - j;
      localGradientDrawable.setColor(paramInt);
      localGradientDrawable.setStroke(getResources().getDimensionPixelSize(i), -1);
      localGradientDrawable.setSize(j, j);
      localGradientDrawable.setShape(1);
      return localGradientDrawable;
      i = 2131299589;
      break;
    }
  }
  
  private void aep(int paramInt)
  {
    if (this.a != null) {
      this.a.aeq(paramInt);
    }
    Iterator localIterator = this.ao.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ImageView localImageView = (ImageView)localEntry.getValue();
      if (paramInt == ((Integer)localEntry.getKey()).intValue()) {
        localImageView.setImageDrawable(a(true, ((Integer)localEntry.getKey()).intValue()));
      } else {
        localImageView.setImageDrawable(a(false, ((Integer)localEntry.getKey()).intValue()));
      }
    }
  }
  
  private void eMX()
  {
    Object localObject1 = (ImageView)findViewById(2131367423);
    Object localObject2 = (ImageView)findViewById(2131367419);
    ImageView localImageView1 = (ImageView)findViewById(2131367420);
    ImageView localImageView2 = (ImageView)findViewById(2131367424);
    ImageView localImageView3 = (ImageView)findViewById(2131367422);
    ImageView localImageView4 = (ImageView)findViewById(2131367421);
    ImageView localImageView5 = (ImageView)findViewById(2131367418);
    this.ao.put(Integer.valueOf(this.eGf), localObject1);
    this.ao.put(Integer.valueOf(this.eGg), localObject2);
    this.ao.put(Integer.valueOf(this.eGh), localImageView1);
    this.ao.put(Integer.valueOf(this.eGi), localImageView2);
    this.ao.put(Integer.valueOf(this.eGj), localImageView3);
    this.ao.put(Integer.valueOf(this.eGk), localImageView4);
    this.ao.put(Integer.valueOf(this.eGl), localImageView5);
    localObject1 = this.ao.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (ImageView)((Map.Entry)localObject2).getValue();
      ((ImageView)localObject2).setImageDrawable(a(false, i));
      ((ImageView)localObject2).setOnClickListener(new axnp(this, i));
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View.inflate(getContext(), 2131560958, this);
    eMX();
  }
  
  public void setColorSelectedListener(axnq paramaxnq)
  {
    this.a = paramaxnq;
  }
  
  public void setSelectedColor(int paramInt)
  {
    aep(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView
 * JD-Core Version:    0.7.0.1
 */