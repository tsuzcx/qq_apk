package dov.com.tencent.biz.qqstory.takevideo.linker;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import pty;
import pty.a;
import ram;

public class VipFrwrdLinkView
  extends FrameLayout
{
  private ImageView IW;
  private URLDrawable U;
  private Context mContext;
  private pty mVideoLinkInfo;
  private TextView mg;
  
  public VipFrwrdLinkView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131559271, this);
    this.IW = ((ImageView)findViewById(2131366240));
    this.mg = ((TextView)findViewById(2131366237));
    this.mContext = paramContext;
  }
  
  void jV(String paramString1, String paramString2)
  {
    this.mg.setText(this.mContext.getString(2131701751, new Object[] { paramString1 }));
    if ((this.U == null) && (paramString2 != null)) {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
    }
    try
    {
      this.U = URLDrawable.getDrawable(paramString2, paramString1);
      this.IW.setImageDrawable(this.U);
      ram.d(getClass().getName(), "setIconURlDrawable:" + paramString2);
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setLinkInfo(pty parampty)
  {
    this.mVideoLinkInfo = parampty;
    if (this.mVideoLinkInfo.a == null) {
      return;
    }
    jV(this.mVideoLinkInfo.a.nickName, this.mVideoLinkInfo.a.headUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView
 * JD-Core Version:    0.7.0.1
 */