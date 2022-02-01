package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

final class OggPageHeader
{
  public static final int EMPTY_PAGE_HEADER_SIZE = 27;
  public static final int MAX_PAGE_PAYLOAD = 65025;
  public static final int MAX_PAGE_SIZE = 65307;
  public static final int MAX_SEGMENT_COUNT = 255;
  private static final int TYPE_OGGS = Util.getIntegerCodeForString("OggS");
  public int bodySize;
  public long granulePosition;
  public int headerSize;
  public final int[] laces = new int['ÿ'];
  public long pageChecksum;
  public int pageSegmentCount;
  public long pageSequenceNumber;
  public int revision;
  private final ParsableByteArray scratch = new ParsableByteArray(255);
  public long streamSerialNumber;
  public int type;
  
  public boolean populate(ExtractorInput paramExtractorInput, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int j = 0;
    this.scratch.reset();
    reset();
    if ((paramExtractorInput.getLength() == -1L) || (paramExtractorInput.getLength() - paramExtractorInput.getPeekPosition() >= 27L))
    {
      i = 1;
      if ((i != 0) && (paramExtractorInput.peekFully(this.scratch.data, 0, 27, true))) {
        break label92;
      }
      if (!paramBoolean) {
        break label84;
      }
    }
    label84:
    label92:
    label121:
    do
    {
      do
      {
        return false;
        i = 0;
        break;
        throw new EOFException();
        if (this.scratch.readUnsignedInt() == TYPE_OGGS) {
          break label121;
        }
      } while (paramBoolean);
      throw new ParserException("expected OggS capture pattern at begin of page");
      this.revision = this.scratch.readUnsignedByte();
      if (this.revision == 0) {
        break label153;
      }
    } while (paramBoolean);
    throw new ParserException("unsupported bit stream revision");
    label153:
    this.type = this.scratch.readUnsignedByte();
    this.granulePosition = this.scratch.readLittleEndianLong();
    this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
    this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
    this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
    this.pageSegmentCount = this.scratch.readUnsignedByte();
    this.headerSize = (this.pageSegmentCount + 27);
    this.scratch.reset();
    paramExtractorInput.peekFully(this.scratch.data, 0, this.pageSegmentCount);
    int i = j;
    while (i < this.pageSegmentCount)
    {
      this.laces[i] = this.scratch.readUnsignedByte();
      this.bodySize += this.laces[i];
      i += 1;
    }
    return true;
  }
  
  public void reset()
  {
    this.revision = 0;
    this.type = 0;
    this.granulePosition = 0L;
    this.streamSerialNumber = 0L;
    this.pageSequenceNumber = 0L;
    this.pageChecksum = 0L;
    this.pageSegmentCount = 0;
    this.headerSize = 0;
    this.bodySize = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ogg.OggPageHeader
 * JD-Core Version:    0.7.0.1
 */