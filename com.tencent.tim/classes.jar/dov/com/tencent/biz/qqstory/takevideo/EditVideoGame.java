package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import aygj;
import aygy;
import aygz;
import ayqb;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import psu;
import psx;
import qvf;

public class EditVideoGame
  extends aygy
{
  private GameResultItem a;
  private StoryVideoItem e;
  private CommentLikeFeedItem f;
  
  private boolean aQx()
  {
    this.a = ((GameResultItem)this.b.a.getParcelable("story_game_result"));
    return this.a != null;
  }
  
  private void eRA()
  {
    if ((this.f == null) || (this.f.mDenyComment == 1))
    {
      this.f = ((CommentLikeFeedItem)((qvf)psx.a(11)).a(this.a.feedId));
      if ((this.f != null) && (this.f.mDenyComment != 1)) {}
    }
    do
    {
      do
      {
        return;
      } while (this.e != null);
      this.e = ((psu)psx.a(5)).a(this.a.vid);
    } while (this.e != null);
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb) {}
  
  public void onCreate()
  {
    super.onCreate();
    if (!aQx()) {
      return;
    }
    ThreadManagerV2.excute(new EditVideoGame.1(this), 32, null, true);
  }
  
  public static final class GameResultItem
    implements Parcelable
  {
    public static final Parcelable.Creator<GameResultItem> CREATOR = new aygj();
    public String cWX;
    public String cWY;
    public String cWZ;
    public String cXa;
    public String cXb;
    public String feedId;
    public String gameId;
    public int pbType;
    public int score;
    public int type;
    public String vid;
    
    public GameResultItem() {}
    
    public GameResultItem(Parcel paramParcel)
    {
      this.type = paramParcel.readInt();
      this.gameId = paramParcel.readString();
      this.score = paramParcel.readInt();
      this.cWX = paramParcel.readString();
      this.feedId = paramParcel.readString();
      this.vid = paramParcel.readString();
      this.cWY = paramParcel.readString();
      this.pbType = paramParcel.readInt();
      this.cWZ = paramParcel.readString();
      this.cXa = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "GameResultItem{type=" + this.type + ", gameId='" + this.gameId + '\'' + ", score=" + this.score + ", extraListJSON=" + this.cWX + ", feedId='" + this.feedId + '\'' + ", vid='" + this.vid + '\'' + ", gameResult='" + this.cWY + '\'' + ", pbType='" + this.pbType + '\'' + ", resultStyleJSON='" + this.cWZ + '\'' + ", gameLinkInfoJSON='" + this.cXa + '\'' + ", pkResultPicPath='" + this.cXb + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.type);
      paramParcel.writeString(this.gameId);
      paramParcel.writeInt(this.score);
      paramParcel.writeString(this.cWX);
      paramParcel.writeString(this.feedId);
      paramParcel.writeString(this.vid);
      paramParcel.writeString(this.cWY);
      paramParcel.writeInt(this.pbType);
      paramParcel.writeString(this.cWZ);
      paramParcel.writeString(this.cXa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoGame
 * JD-Core Version:    0.7.0.1
 */