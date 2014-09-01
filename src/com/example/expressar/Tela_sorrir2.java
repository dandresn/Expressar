package com.example.expressar;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.VideoView;

public class Tela_sorrir2 extends Activity {
	
	private static String TAG;
	private Camera mCamera;
	private CameraPreview mPreview;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_sorrir2);
		
		ImageButton btnInicio = (ImageButton) findViewById(R.id.btnInicio);
		ImageButton btnVoltar1 = (ImageButton) findViewById(R.id.btnVoltar1);
		ImageButton btnAvancar1 = (ImageButton) findViewById(R.id.btnAvancar1);
		Button btnMotiva = (Button) findViewById(R.id.btnMotiva);
		Button btnZera = (Button) findViewById(R.id.btnZera);
		
		btnMotiva.setOnClickListener(clickListener);
		btnInicio.setOnClickListener(clickListener);
		btnVoltar1.setOnClickListener(clickListener);
		btnAvancar1.setOnClickListener(clickListener);
		btnZera.setOnClickListener(clickListener);
		
		VideoView video = (VideoView) findViewById(R.id.videoSorrir2);

		Uri src = Uri.parse("android.resource://com.example.expressar/raw/sorrir3");
		video.setVideoURI(src);
		
		video.start();
		
	
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        
	}
	
	public static Camera getCameraInstance(){
	    Camera cam = null;
	    int cameraCount = 0;
	    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
	    cameraCount = Camera.getNumberOfCameras();
	    for(int camIdx = 0; camIdx<cameraCount; camIdx++){
	    	Camera.getCameraInfo(camIdx, cameraInfo);
	    	if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT)
	    		try {
	    			cam = Camera.open(camIdx); // attempt to get a Camera instance
	    		}
	    		catch (Exception e){
	    			// Camera is not available (in use or does not exist)
	    			Log.e(TAG, "Falha ao abrir a c‰mera: " + e.getLocalizedMessage());
	    		}
	    }
	    return cam; // returns null if camera is unavailable
	}
protected void onStop(){
	super.onStop();
	releaseCamera();
}
private void releaseCamera(){
        if (mCamera != null){
            mCamera.release();        // release the camera for other applications
            mCamera = null;
        }
}
private OnClickListener clickListener = new OnClickListener() {

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent inicio = new Intent(Tela_sorrir2.this, Licoes.class);
		Intent voltar = new Intent(Tela_sorrir2.this, Tela_sorrir1.class);
		Intent avancar = new Intent(Tela_sorrir2.this, Tela_sorrir3.class);
		VideoView video = (VideoView) findViewById(R.id.videoSorrir2);
		
		
			//video.setMediaController(new MediaController(this));
		
		
		switch (v.getId()) {
		
		case R.id.btnInicio:
			releaseCamera();
			startActivity(inicio);
			break;
		case R.id.btnVoltar1:
			releaseCamera();
			startActivity(voltar);
			break;
		case R.id.btnAvancar1:
			releaseCamera();
			startActivity(avancar);
			break;
		case R.id.btnZera:	
			Uri src = Uri.parse("android.resource://com.example.expressar/raw/sorrir3");
			video.setVideoURI(src);
			video.start();
			break;
		case R.id.btnMotiva:
			Uri src2 = Uri.parse("android.resource://com.example.expressar/raw/sorrir4");
			video.setVideoURI(src2);
			video.start();
		}
		
	}
};
}
