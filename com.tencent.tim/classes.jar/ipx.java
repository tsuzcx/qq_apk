import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.model.SizeI;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

public class ipx
  extends ipy
{
  private final String TAG = "PAGFilter-" + Integer.toHexString(hashCode());
  private Frame d;
  private int height = 1280;
  private long my;
  private long mz;
  private PAGFile pagFile;
  private PAGRenderer pagRenderer;
  private PAGSurface pagSurface;
  private int width = 720;
  
  public ipx(int paramInt1, int paramInt2)
  {
    super(1);
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  private void apq()
  {
    if (this.pagFile != null)
    {
      if (this.pagSurface != null)
      {
        this.pagSurface.release();
        QLog.d(this.TAG, 1, "applyPag: surface#" + Integer.toHexString(this.pagSurface.hashCode()) + " released");
        this.pagSurface = null;
      }
      if (this.pagRenderer == null) {
        QLog.e(this.TAG, 1, "applyPag: not inited yet");
      }
    }
    else
    {
      return;
    }
    this.pagRenderer.setFile(this.pagFile);
    this.pagSurface = PAGSurface.FromTexture(this.d.getTextureId(), this.width, this.height, true);
    QLog.d(this.TAG, 1, "applyPag: create surface#" + Integer.toHexString(this.pagSurface.hashCode()));
    this.pagRenderer.setSurface(this.pagSurface);
    this.my = (this.pagFile.duration() / 1000L);
  }
  
  @NotNull
  protected Frame a(List<iqa> paramList, long paramLong)
  {
    if ((this.mz == 0L) || (this.mz > paramLong)) {
      this.mz = paramLong;
    }
    int j = Math.min(this.pagFile.numImages(), paramList.size());
    int i = 0;
    while (i < j)
    {
      Object localObject = ((iqa)paramList.get(i)).frame;
      localObject = PAGImage.FromTexture(((Frame)localObject).getTextureId(), 3553, ((Frame)localObject).width, ((Frame)localObject).height, true);
      if (localObject != null)
      {
        ((PAGImage)localObject).setScaleMode(3);
        this.pagRenderer.replaceImage(i, (PAGImage)localObject);
      }
      i += 1;
    }
    double d1 = (paramLong - this.mz) % this.my / this.my;
    this.pagRenderer.setProgress(d1);
    this.pagRenderer.flush();
    return this.d;
  }
  
  public SizeI a()
  {
    return new SizeI(this.pagFile.width(), this.pagFile.height());
  }
  
  public List<Pair<RectF, Matrix>> ak()
  {
    int k = 0;
    PAGComposition localPAGComposition = this.pagRenderer.getRootComposition();
    int n = this.pagFile.numImages();
    int m = localPAGComposition.numLayers();
    ArrayList localArrayList = new ArrayList(n);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      localArrayList.add(null);
      i += 1;
    }
    while (j < m)
    {
      PAGLayer localPAGLayer = localPAGComposition.getLayerAt(j);
      if (localPAGLayer.layerType() == 5) {
        localArrayList.set(localPAGLayer.editableIndex(), new Pair(localPAGLayer.getBounds(), localPAGLayer.getTotalMatrix()));
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public void jt(String paramString)
  {
    this.pagFile = PAGFile.Load(paramString);
    QLog.d(this.TAG, 1, "applyMaterial: " + paramString + " loaded, width=" + this.pagFile.width() + ", height=" + this.pagFile.height());
    apq();
  }
  
  protected void onDestroy()
  {
    QLog.d(this.TAG, 1, "onDestroy");
    if (this.pagRenderer != null)
    {
      this.pagRenderer.setSurface(null);
      this.pagRenderer = null;
    }
    if (this.pagSurface != null)
    {
      this.pagSurface.release();
      QLog.d(this.TAG, 1, "onDestroy: surface#" + Integer.toHexString(this.pagSurface.hashCode()) + " released");
      this.pagSurface = null;
    }
    if (this.d != null)
    {
      this.d.clear();
      QLog.d(this.TAG, 1, "onDestroy: frame#" + Integer.toHexString(this.d.hashCode()) + " cleared");
      this.d = null;
    }
  }
  
  protected void onInit()
  {
    QLog.d(this.TAG, 1, "onInit");
    if (this.d == null)
    {
      this.d = new Frame();
      this.d.bindFrame(-1, this.width, this.height, 0.0D);
      QLog.d(this.TAG, 1, "onInit: create frame#" + Integer.toHexString(this.d.hashCode()));
    }
    this.pagRenderer = new PAGRenderer();
    QLog.d(this.TAG, 1, "onInit: create render#" + Integer.toHexString(this.pagRenderer.hashCode()));
    apq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipx
 * JD-Core Version:    0.7.0.1
 */