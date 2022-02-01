import android.content.Context;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;

public class axnw
{
  private axnr jdField_a_of_type_Axnr;
  private axnw.a jdField_a_of_type_Axnw$a;
  
  private void a(TAVCutSession paramTAVCutSession, int paramInt1, String paramString, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    TextItem localTextItem = new TextItem();
    localTextItem.text = paramString;
    localTextItem.textColor = paramInt1;
    localArrayList.add(localTextItem);
    paramString = new StickerModel();
    paramString.setAssetFilePath("ae_editor_text_main.pag");
    paramString.setCenterX(0.5F);
    paramString.setCenterY(0.6F);
    paramString.setScale(0.5F);
    paramString.setMaxScale(1.0F);
    paramString.setMinScale(0.2F);
    paramString.setTextItems(localArrayList);
    if ((paramTAVCutSession instanceof TAVCutImageSession))
    {
      ((TAVCutImageSession)paramTAVCutSession).addSticker(paramInt2, paramString);
      return;
    }
    ((TAVCutVideoSession)paramTAVCutSession).addSticker(paramString);
  }
  
  private void eNc()
  {
    if (this.jdField_a_of_type_Axnr != null) {
      this.jdField_a_of_type_Axnr.setOnDismissListener(new axnz(this));
    }
  }
  
  public void a(Context paramContext, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession)
  {
    if ((this.jdField_a_of_type_Axnr != null) && (this.jdField_a_of_type_Axnr.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Axnr = new axnr(paramContext, 2131755011, new axnx(this, paramTextEditorData, paramTAVCutSession));
    eNc();
    paramContext = new axnr.b();
    paramContext.aer(paramTextEditorData.getTextColor());
    paramContext.setContent(paramTextEditorData.getContent());
    this.jdField_a_of_type_Axnr.a("default_sticker_id", paramContext);
    this.jdField_a_of_type_Axnr.show();
  }
  
  public void a(Context paramContext, TAVCutSession paramTAVCutSession, int paramInt)
  {
    if ((this.jdField_a_of_type_Axnr != null) && (this.jdField_a_of_type_Axnr.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Axnr = new axnr(paramContext, 2131755011, new axny(this, paramTAVCutSession, paramInt));
    eNc();
    this.jdField_a_of_type_Axnr.show();
    axim.a().eKI();
  }
  
  public void a(axnw.a parama)
  {
    this.jdField_a_of_type_Axnw$a = parama;
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Axnr != null) {
      this.jdField_a_of_type_Axnr.onResume();
    }
  }
  
  public static abstract interface a
  {
    public abstract void ayk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnw
 * JD-Core Version:    0.7.0.1
 */