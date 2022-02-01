package net.jarlehansen.protobuf.original;

public final class WireFormat
{
  static final int MESSAGE_SET_ITEM = 1;
  static final int MESSAGE_SET_MESSAGE = 3;
  static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
  static final int MESSAGE_SET_TYPE_ID = 2;
  static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
  static final int TAG_TYPE_BITS = 3;
  static final int TAG_TYPE_MASK = 7;
  public static final int WIRETYPE_END_GROUP = 4;
  public static final int WIRETYPE_FIXED32 = 5;
  public static final int WIRETYPE_FIXED64 = 1;
  public static final int WIRETYPE_LENGTH_DELIMITED = 2;
  public static final int WIRETYPE_START_GROUP = 3;
  public static final int WIRETYPE_VARINT = 0;
  
  public static int getTagFieldNumber(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static int getTagWireType(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int makeTag(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.original.WireFormat
 * JD-Core Version:    0.7.0.1
 */