import QC.CommonRsp;
import QC.GetSuixintieSigFontRsp;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.1.1;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.1.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alfj
  implements acci
{
  public alfj(StickyNoteShopLayout paramStickyNoteShopLayout, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof GetSuixintieSigFontRsp)) {
      if ((((GetSuixintieSigFontRsp)paramObject).isEnd != 1) || (((GetSuixintieSigFontRsp)paramObject).vItems.size() != 1)) {}
    }
    while ((this.us) || (StickyNoteShopLayout.a(this.this$0).getItemCount() != 0))
    {
      return;
      if (!this.us) {
        aqhq.writeFile(((GetSuixintieSigFontRsp)paramObject).toByteArray(), StickyNoteShopLayout.CACHE_PATH + '_' + StickyNoteShopLayout.a(this.this$0));
      }
      paramObject = (GetSuixintieSigFontRsp)paramObject;
      QLog.d("StickyNoteShopLayout", 2, " type:" + paramInt + " isSuccess:" + paramBoolean + " isLoadMore:" + this.us + " size:" + paramObject.stRet.ret);
      StickyNoteShopLayout.a(this.this$0, paramObject.strAttachInfo);
      if ((paramObject.stRet.ret == 0) && (paramObject.vItems != null) && (paramObject.vItems.size() > 0))
      {
        ThreadManagerV2.getUIHandlerV2().post(new StickyNoteShopLayout.1.1(this, paramObject));
        return;
      }
      StickyNoteShopLayout.a(this.this$0, true);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new StickyNoteShopLayout.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfj
 * JD-Core Version:    0.7.0.1
 */