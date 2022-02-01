package me.ele.uetool;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.util.JarResource;

public class UETSubMenu
  extends LinearLayout
{
  private ChangeStatus changeStatus = new ChangeStatus();
  private final int padding = DimenUtil.dip2px(5.0F);
  private SubMenu subMenu;
  private ImageView vImage;
  private TextView vTitle;
  
  public UETSubMenu(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public UETSubMenu(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UETSubMenu(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, JarResource.getIdByName("layout", "qb_uet_sub_menu_layout"), this);
    setGravity(17);
    setOrientation(1);
    setPadding(this.padding, 0, this.padding, 0);
    setTranslationY(DimenUtil.dip2px(2.0F));
    this.vImage = ((ImageView)findViewById(JarResource.getIdByName("id", "image")));
    this.vTitle = ((TextView)findViewById(JarResource.getIdByName("id", "title")));
  }
  
  public ChangeStatus getChangeStatus()
  {
    return this.changeStatus;
  }
  
  public void update(SubMenu paramSubMenu)
  {
    this.subMenu = paramSubMenu;
    this.vImage.setImageResource(paramSubMenu.getChosenImageRes());
    this.vTitle.setText(paramSubMenu.getTitle());
    setOnClickListener(paramSubMenu.getOnClickListener());
  }
  
  public class ChangeStatus
    implements UETSubMenu.IchangeStatus
  {
    public ChangeStatus() {}
    
    public void changeStatus(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        UETSubMenu.this.vImage.setImageResource(UETSubMenu.this.subMenu.getImageRes());
        UETSubMenu.this.vTitle.setTextColor(Color.parseColor("#ffffff"));
        return;
      }
      UETSubMenu.this.vImage.setImageResource(UETSubMenu.this.subMenu.getChosenImageRes());
      UETSubMenu.this.vTitle.setTextColor(Color.parseColor("#000000"));
    }
  }
  
  public static abstract interface IchangeStatus
  {
    public abstract void changeStatus(boolean paramBoolean);
  }
  
  public static class SubMenu
  {
    private int chosenImageRes;
    private int imageRes;
    private View.OnClickListener onClickListener;
    private String title;
    
    public SubMenu(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
    {
      this.title = paramString;
      this.imageRes = paramInt1;
      this.chosenImageRes = paramInt2;
      this.onClickListener = paramOnClickListener;
    }
    
    public int getChosenImageRes()
    {
      return this.chosenImageRes;
    }
    
    public int getImageRes()
    {
      return this.imageRes;
    }
    
    public View.OnClickListener getOnClickListener()
    {
      return this.onClickListener;
    }
    
    public String getTitle()
    {
      return this.title;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETSubMenu
 * JD-Core Version:    0.7.0.1
 */