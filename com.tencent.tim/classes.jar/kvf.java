import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;

public class kvf
  extends TextBase
{
  private static final int DEFAULT_TEXT_COLOR = Color.parseColor("#262626");
  private final int TEXT_SIZE = Utils.dp2px(16.0D);
  private NativeCommentTextView a;
  private final int aMc = 5;
  
  public kvf(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeCommentTextView(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setTextSize(0, this.TEXT_SIZE);
    this.a.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.a.setIncludeFontPadding(false);
    this.a.setTextColor(DEFAULT_TEXT_COLOR);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.setAttribute(paramInt, paramObject);
    } while (!(paramObject instanceof ktm));
    this.a.setCommentModel((ktm)paramObject);
    return true;
  }
  
  public void setModel(kte paramkte, View paramView)
  {
    this.a.setModel(paramkte, paramView);
  }
  
  public void setModel(kte paramkte, View paramView, int paramInt)
  {
    this.a.setModel(paramkte, paramView, paramInt);
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kvf(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvf
 * JD-Core Version:    0.7.0.1
 */