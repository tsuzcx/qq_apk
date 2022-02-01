import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import java.util.HashMap;

public class avxa
{
  public static class a
  {
    private avwv jdField_a_of_type_Avwv;
    private PanoramaPieceManager jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager;
    private boolean dpl;
    private boolean dpm;
    private boolean dpn;
    private boolean dpo;
    private boolean dpp;
    private boolean dpq;
    private Drawable gV;
    private boolean isNeedPieceLoad;
    private int modeType;
    private int panoramaType;
    private HashMap<String, String> qK;
    private int renderMode = 1;
    private int showType = 0;
    private String smallUrl;
    private String thumbUrl;
    
    public a(int paramInt)
    {
      this.modeType = paramInt;
      if (paramInt == 0)
      {
        this.isNeedPieceLoad = false;
        this.jdField_a_of_type_Avwv = new avww(this.isNeedPieceLoad);
      }
      while (paramInt != 2) {
        return;
      }
      this.isNeedPieceLoad = true;
      this.jdField_a_of_type_Avwv = new avwu(this.isNeedPieceLoad);
    }
    
    public int PQ()
    {
      return this.modeType;
    }
    
    public int PR()
    {
      return this.panoramaType;
    }
    
    public void WS(boolean paramBoolean)
    {
      this.dpq = paramBoolean;
    }
    
    public avwv a()
    {
      return this.jdField_a_of_type_Avwv;
    }
    
    public a a(int paramInt)
    {
      this.showType = paramInt;
      if (this.jdField_a_of_type_Avwv != null) {
        this.jdField_a_of_type_Avwv.setShowType(paramInt);
      }
      return this;
    }
    
    public a a(Drawable paramDrawable)
    {
      this.gV = paramDrawable;
      this.dpq = true;
      if ((paramDrawable != null) && (this.jdField_a_of_type_Avwv != null)) {
        this.jdField_a_of_type_Avwv.setImageSize(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      }
      return this;
    }
    
    public a a(avwv.a parama)
    {
      if ((this.jdField_a_of_type_Avwv != null) && (parama != null)) {
        this.jdField_a_of_type_Avwv.a(parama);
      }
      return this;
    }
    
    public a a(String paramString)
    {
      this.thumbUrl = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return this;
      }
      if (this.qK == null) {
        this.qK = new HashMap();
      }
      this.qK.put(paramString1, paramString2);
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.dpl = paramBoolean;
      return this;
    }
    
    public PanoramaPieceManager a()
    {
      return this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager;
    }
    
    public void a(PanoramaPieceManager paramPanoramaPieceManager)
    {
      this.jdField_a_of_type_CooperationQzonePanoramaPiecePanoramaPieceManager = paramPanoramaPieceManager;
      if (this.jdField_a_of_type_Avwv != null) {
        this.jdField_a_of_type_Avwv.a(paramPanoramaPieceManager);
      }
    }
    
    public boolean aLN()
    {
      return this.dpl;
    }
    
    public boolean aLO()
    {
      return this.dpm;
    }
    
    public boolean aLP()
    {
      return this.dpn;
    }
    
    public boolean aLQ()
    {
      return this.dpo;
    }
    
    public boolean aLR()
    {
      return this.dpp;
    }
    
    public boolean aLS()
    {
      return this.dpq;
    }
    
    public boolean aLT()
    {
      return this.isNeedPieceLoad;
    }
    
    public a b(int paramInt)
    {
      this.renderMode = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.smallUrl = paramString;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.dpm = paramBoolean;
      return this;
    }
    
    public Drawable bh()
    {
      this.dpq = false;
      return this.gV;
    }
    
    public a c(int paramInt)
    {
      this.panoramaType = paramInt;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.dpn = paramBoolean;
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      this.dpo = paramBoolean;
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      this.dpp = paramBoolean;
      return this;
    }
    
    public int getRenderMode()
    {
      return this.renderMode;
    }
    
    public int getShowType()
    {
      return this.showType;
    }
    
    public String getSmallUrl()
    {
      return this.smallUrl;
    }
    
    public String getThumbUrl()
    {
      return this.thumbUrl;
    }
    
    public String rT(String paramString)
    {
      if ((TextUtils.isEmpty(paramString)) || (this.qK == null)) {
        return null;
      }
      return (String)this.qK.get(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxa
 * JD-Core Version:    0.7.0.1
 */