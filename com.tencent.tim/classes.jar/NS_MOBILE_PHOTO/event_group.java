package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class event_group
  extends JceStruct
{
  static ArrayList<event_card> cache_cards;
  static ArrayList<event_cloud_card> cache_cloudCards;
  static ArrayList<event_card_type> cache_types = new ArrayList();
  public ArrayList<event_card> cards;
  public ArrayList<event_cloud_card> cloudCards;
  public String groupid = "";
  public int type;
  public ArrayList<event_card_type> types;
  
  static
  {
    Object localObject = new event_card_type();
    cache_types.add(localObject);
    cache_cards = new ArrayList();
    localObject = new event_card();
    cache_cards.add(localObject);
    cache_cloudCards = new ArrayList();
    localObject = new event_cloud_card();
    cache_cloudCards.add(localObject);
  }
  
  public event_group() {}
  
  public event_group(String paramString, ArrayList<event_card_type> paramArrayList, ArrayList<event_card> paramArrayList1, int paramInt, ArrayList<event_cloud_card> paramArrayList2)
  {
    this.groupid = paramString;
    this.types = paramArrayList;
    this.cards = paramArrayList1;
    this.type = paramInt;
    this.cloudCards = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupid = paramJceInputStream.readString(0, true);
    this.types = ((ArrayList)paramJceInputStream.read(cache_types, 1, true));
    this.cards = ((ArrayList)paramJceInputStream.read(cache_cards, 2, false));
    this.type = paramJceInputStream.read(this.type, 3, false);
    this.cloudCards = ((ArrayList)paramJceInputStream.read(cache_cloudCards, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.groupid, 0);
    paramJceOutputStream.write(this.types, 1);
    if (this.cards != null) {
      paramJceOutputStream.write(this.cards, 2);
    }
    paramJceOutputStream.write(this.type, 3);
    if (this.cloudCards != null) {
      paramJceOutputStream.write(this.cloudCards, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.event_group
 * JD-Core Version:    0.7.0.1
 */