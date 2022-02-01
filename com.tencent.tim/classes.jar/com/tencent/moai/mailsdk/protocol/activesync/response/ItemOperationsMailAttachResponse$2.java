package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.protocol.activesync.Status.CommonStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.ItemOperationStatus;
import com.tencent.moai.mailsdk.util.aswbxml.ASWBXML.StreamHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class ItemOperationsMailAttachResponse$2
  implements ASWBXML.StreamHandler
{
  ItemOperationsMailAttachResponse$2(ItemOperationsMailAttachResponse paramItemOperationsMailAttachResponse, ItemOperationsMailAttachResponse.TagStack paramTagStack, ByteArrayOutputStream paramByteArrayOutputStream1, ByteArrayOutputStream paramByteArrayOutputStream2, ByteArrayOutputStream paramByteArrayOutputStream3, ByteArrayOutputStream paramByteArrayOutputStream4, OutputStream paramOutputStream, long[] paramArrayOfLong, ByteArrayOutputStream paramByteArrayOutputStream5) {}
  
  public void onData(byte paramByte)
  {
    try
    {
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Status"))
      {
        this.val$commonStatusStream.write(paramByte);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Status"))
      {
        this.val$itemOperationStatusStream.write(paramByte);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-FileReference"))
      {
        this.val$fileReferenceStream.write(paramByte);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Properties-ContentType"))
      {
        this.val$contentTypeStream.write(paramByte);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Properties-Data"))
      {
        this.val$dataBufferStream.write(paramByte);
        if (this.val$dataBufferStream.size() > 1024)
        {
          byte[] arrayOfByte = this.val$dataBufferStream.toByteArray();
          this.val$tmpOutputStream.write(arrayOfByte);
          this.val$dataBufferStream.reset();
          long[] arrayOfLong = this.val$downloadBytes;
          arrayOfLong[0] += arrayOfByte.length;
          if (ItemOperationsMailAttachResponse.access$000(this.this$0) != null) {
            ItemOperationsMailAttachResponse.access$000(this.this$0).onProgress(this.val$downloadBytes[0]);
          }
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void onData(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Status"))
      {
        this.val$commonStatusStream.write(paramArrayOfByte, 0, paramInt);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Status"))
      {
        this.val$itemOperationStatusStream.write(paramArrayOfByte, 0, paramInt);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-FileReference"))
      {
        this.val$fileReferenceStream.write(paramArrayOfByte, 0, paramInt);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Properties-ContentType"))
      {
        this.val$contentTypeStream.write(paramArrayOfByte, 0, paramInt);
        return;
      }
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Properties-Data"))
      {
        this.val$tmpOutputStream.write(paramArrayOfByte, 0, paramInt);
        paramArrayOfByte = this.val$downloadBytes;
        paramArrayOfByte[0] += paramInt;
      }
      return;
    }
    catch (IOException paramArrayOfByte) {}
  }
  
  public void onEnd()
  {
    try
    {
      if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Status")) {
        ItemOperationsMailAttachResponse.access$102(this.this$0, new CommonStatus(Integer.parseInt(new String(this.val$commonStatusStream.toByteArray()))));
      }
      for (;;)
      {
        this.val$tagStack.pop();
        return;
        if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Status"))
        {
          ItemOperationsMailAttachResponse.access$202(this.this$0, new ItemOperationStatus(Integer.parseInt(new String(this.val$itemOperationStatusStream.toByteArray()))));
        }
        else if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-FileReference"))
        {
          ItemOperationsMailAttachResponse.access$302(this.this$0, new String(this.val$fileReferenceStream.toByteArray()));
        }
        else if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Properties-ContentType"))
        {
          ItemOperationsMailAttachResponse.access$402(this.this$0, new String(this.val$contentTypeStream.toByteArray()));
        }
        else if (this.val$tagStack.getCurrentTag().equals("ItemOperations-Response-Fetch-Properties-Data"))
        {
          if (this.val$dataBufferStream.size() > 0)
          {
            byte[] arrayOfByte = this.val$dataBufferStream.toByteArray();
            this.val$tmpOutputStream.write(arrayOfByte);
            this.val$dataBufferStream.reset();
            long[] arrayOfLong = this.val$downloadBytes;
            arrayOfLong[0] += arrayOfByte.length;
          }
          this.val$tmpOutputStream.flush();
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void onStart(String paramString)
  {
    this.val$tagStack.push(paramString);
  }
  
  public void onSwitch(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.ItemOperationsMailAttachResponse.2
 * JD-Core Version:    0.7.0.1
 */