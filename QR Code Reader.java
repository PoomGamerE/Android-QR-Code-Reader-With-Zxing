public static String ScanQR(Bitmap bitmap){
        String Data = null;
        int[] intArray = new int[bMap.getWidth() * bMap.getHeight()];
        bMap.getPixels(intArray, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());
        LuminanceSource source = new RGBLuminanceSource(bMap.getWidth(), bMap.getHeight(), intArray);
        BinaryBitmap BB1 = new BinaryBitmap(new HybridBinarizer(source));
        com.google.zxing.Result QRCode = null;
        try {
            QRCode = new QRCodeReader().decode(BB1);
        } catch (Exception ignored) {
        }
        Data = QRCode.getText();
        return Data;
    }
