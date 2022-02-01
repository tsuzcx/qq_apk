import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public abstract class nlm
{
  public static int ban = 32;
  protected nlo a;
  public int bao = 16;
  public int bap = 18;
  public BaseData g;
  public View itemView;
  public float kE = 14.0F;
  public int textColor;
  public float textSize;
  
  public nlm() {}
  
  public nlm(View paramView, BaseData paramBaseData)
  {
    this.itemView = paramView;
    this.g = paramBaseData;
  }
  
  public abstract void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean);
  
  public void a(nlo paramnlo)
  {
    this.a = paramnlo;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    this.g = paramBaseData2;
    a(paramBaseData1, paramBaseData2, paramBoolean);
  }
  
  public void k(String paramString, Bitmap paramBitmap) {}
  
  public void onShow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlm
 * JD-Core Version:    0.7.0.1
 */