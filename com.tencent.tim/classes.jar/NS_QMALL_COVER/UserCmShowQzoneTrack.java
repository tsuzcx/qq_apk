package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UserCmShowQzoneTrack
  extends JceStruct
{
  static ArrayList<CmShowQzoneTrack> cache_vecQzoneTrack = new ArrayList();
  static ArrayList<CmShowQzoneTrack> cache_vecQzoneTrack3D;
  public ArrayList<CmShowQzoneTrack> vecQzoneTrack;
  public ArrayList<CmShowQzoneTrack> vecQzoneTrack3D;
  
  static
  {
    CmShowQzoneTrack localCmShowQzoneTrack = new CmShowQzoneTrack();
    cache_vecQzoneTrack.add(localCmShowQzoneTrack);
    cache_vecQzoneTrack3D = new ArrayList();
    localCmShowQzoneTrack = new CmShowQzoneTrack();
    cache_vecQzoneTrack3D.add(localCmShowQzoneTrack);
  }
  
  public UserCmShowQzoneTrack() {}
  
  public UserCmShowQzoneTrack(ArrayList<CmShowQzoneTrack> paramArrayList1, ArrayList<CmShowQzoneTrack> paramArrayList2)
  {
    this.vecQzoneTrack = paramArrayList1;
    this.vecQzoneTrack3D = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecQzoneTrack = ((ArrayList)paramJceInputStream.read(cache_vecQzoneTrack, 0, false));
    this.vecQzoneTrack3D = ((ArrayList)paramJceInputStream.read(cache_vecQzoneTrack3D, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecQzoneTrack != null) {
      paramJceOutputStream.write(this.vecQzoneTrack, 0);
    }
    if (this.vecQzoneTrack3D != null) {
      paramJceOutputStream.write(this.vecQzoneTrack3D, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.UserCmShowQzoneTrack
 * JD-Core Version:    0.7.0.1
 */