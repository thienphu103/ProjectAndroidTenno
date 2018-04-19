package com.example.a.projectapptenno.Admin;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a.projectapptenno.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Add extends AppCompatActivity {
    Button btn_continue, btn_gallary, btn_camera;
    View view_nhap_hang;
    EditText buaan, ten, thoitiet, gioithieu, nguyenlieu, chuanbi, cachlam;
    String txt_buaan, txt_ten, txt_thoitiet, txt_gioithieu, txt_nguyenlieu, txt_chuanbi, txt_cachlam;
    private String diachi_post;
    private String email_post;
    private String ten_post;
    private ImageView img_view_photo_nhaphang;
    private int CAMERA_REQUEST = 1;
    private int CAMERA_REQUEST_MAX = 1999;
    private Uri picUri;
    private int PIC_CROP = 3;
    String txt_user;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static final int PERMISSION_REQUEST_CAMERA = 0;
    private RelativeLayout layout_back_nhaphang;
    private int index_listview;
    private int index_listview_sp;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/crud.php";
    private String id_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initControl();
        initData();
        initEvent();
        initOnClick();

    }

    private void initOnClick() {

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_ten = ten.getText().toString();
                txt_buaan = buaan.getText().toString();
                txt_thoitiet = thoitiet.getText().toString();
                txt_gioithieu = gioithieu.getText().toString();
                txt_nguyenlieu = nguyenlieu.getText().toString();
                txt_chuanbi = chuanbi.getText().toString();
                txt_cachlam = cachlam.getText().toString();
                if (!(txt_ten.isEmpty())
                        && !(txt_buaan.isEmpty())
                        && !(txt_thoitiet.isEmpty())
                        && !(txt_gioithieu.isEmpty())
                        && !(txt_nguyenlieu.isEmpty())
                        && !(txt_chuanbi.isEmpty())
                        && !(txt_cachlam.isEmpty())) {
                    if (id_update != null) {
                        updateData();
                    } else {
                        upData();
                    }


                } else {
                    if ((txt_ten.isEmpty())) {
                        ten.setHint("*Xin vui lòng không bỏ trống [ten] ");
                        ten.setHintTextColor(Color.RED);
                    }
                    if ((txt_buaan.isEmpty())) {
                        buaan.setHint("*Xin vui lòng không bỏ trống [bua_an] ");
                        buaan.setHintTextColor(Color.RED);
                    }


                    if ((txt_thoitiet.isEmpty())) {
                        thoitiet.setHint("*Xin vui lòng không bỏ trống` [thoi_tiet] ");
                        thoitiet.setHintTextColor(Color.RED);
                    }

                    if ((txt_gioithieu.isEmpty())) {
                        gioithieu.setHint("*Xin vui lòng không bỏ trống` [gioi_thieu] ");
                        gioithieu.setHintTextColor(Color.RED);
                    }

                    if ((txt_nguyenlieu.isEmpty())) {
                        nguyenlieu.setHint("*Xin vui lòng không bỏ trống` [nguyen_lieu] ");
                        nguyenlieu.setHintTextColor(Color.RED);
                    }

                    if ((txt_chuanbi.isEmpty())) {
                        chuanbi.setHint("*Xin vui lòng không bỏ trống` [chuan_bi] ");
                        chuanbi.setHintTextColor(Color.RED);
                    }

                    if ((txt_cachlam.isEmpty())) {
                        cachlam.setHint("*Xin vui lòng không bỏ trống`[cach_lam] ");
                        cachlam.setHintTextColor(Color.RED);
                    }


                }
            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Build.VERSION.SDK_INT > 21) {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_GRANTED) {
                            // Permission is already available, start camera preview
                            Snackbar.make(view_nhap_hang,
                                    "Camera permission is available (API: " + Build.VERSION.SDK_INT + "). Starting preview.",
                                    Snackbar.LENGTH_SHORT).show();

                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePictureIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                                startActivityForResult(takePictureIntent, CAMERA_REQUEST_MAX);
                            }
                        } else {
                            // Permission is missing and must be requested.
                            requestCameraPermission();
                        }
                    } else {
                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                    }


//                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
//                            == PackageManager.PERMISSION_GRANTED) {
//                        // Permission is already available, start camera preview
//                        Snackbar.make(view_nhap_hang,
//                                "Camera permission is available. Starting preview.",
//                                Snackbar.LENGTH_SHORT).show();
//
//                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//                            startActivityForResult(takePictureIntent, CAMERA_REQUEST);
//                        }
//                    } else {
//                        // Permission is missing and must be requested.
//                        requestCameraPermission();
//                    }


                    // use standard intent to capture an image
                } catch (ActivityNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_gallary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent imageDownload = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imageDownload.putExtra("crop", "true");
                imageDownload.putExtra("aspectX", 4);
                imageDownload.putExtra("aspectY", 3);
                imageDownload.putExtra("outputX", 1280);
                imageDownload.putExtra("outputY", 720);
                imageDownload.putExtra("return-data", true);
                startActivityForResult(imageDownload, 2);

            }
        });


    }

    private void initData() {


    }

    private void performCrop() {
        // take care of exceptions
        try {
            // call the standard crop action intent (the user device may not
            // support it)
            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 4);
            cropIntent.putExtra("aspectY", 3);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 1280);
            cropIntent.putExtra("outputY", 720);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, PIC_CROP);
        }
        // respond to users whose devices do not support the crop action
        catch (ActivityNotFoundException anfe) {

        }
    }

    public void upData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_GET_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();
                Bitmap bitmap = ((BitmapDrawable) img_view_photo_nhaphang.getDrawable()).getBitmap();
//                Bitmap image_fb = BitmapFactory.decodeStream(url_fb.openConnection().getInputStream());
                String image = decodeImage(bitmap);
                stringMap.put("meal", txt_buaan);
                stringMap.put("title", txt_ten);
                stringMap.put("intro", txt_gioithieu);
                stringMap.put("id_temp", txt_thoitiet);
                stringMap.put("material", txt_nguyenlieu);
                stringMap.put("image_food", image);
                stringMap.put("prepare", txt_chuanbi);
                stringMap.put("guide", txt_cachlam);
                stringMap.put("select", "6");
                Log.d("IMAGE", image + "");
                return stringMap;

            }

        };
        requestQueue.add(stringRequest);
    }

    public void updateData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_GET_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Sửa Thành Công", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();
                Bitmap bitmap = ((BitmapDrawable) img_view_photo_nhaphang.getDrawable()).getBitmap();
//                Bitmap image_fb = BitmapFactory.decodeStream(url_fb.openConnection().getInputStream());
                String image = decodeImage(bitmap);
                stringMap.put("meal", txt_buaan);
                stringMap.put("title", txt_ten);
                stringMap.put("intro", txt_gioithieu);
                stringMap.put("id_temp", txt_thoitiet);
                stringMap.put("material", txt_nguyenlieu);
                stringMap.put("image_food", image);
                stringMap.put("prepare", txt_chuanbi);
                stringMap.put("guide", txt_cachlam);
                stringMap.put("select", "7");
                stringMap.put("id", id_update);
                Log.d("IMAGE", image + "");
                return stringMap;

            }

        };
        requestQueue.add(stringRequest);
    }

    private void initControl() {
        btn_continue = (Button) findViewById(R.id.btn_nhaphang_nhaphang);
        buaan = (EditText) findViewById(R.id.edt_add_buaan);
        thoitiet = (EditText) findViewById(R.id.edt_add_ndo);
        ten = (EditText) findViewById(R.id.edt_add_ten);
        gioithieu = (EditText) findViewById(R.id.edt_add_gthieu);
        nguyenlieu = (EditText) findViewById(R.id.edt_add_nlieu);
        chuanbi = (EditText) findViewById(R.id.edt_add_cbi);
        cachlam = (EditText) findViewById(R.id.edt_add_cachlam);
        btn_camera = (Button) findViewById(R.id.btn_camera_nhaphang);
        btn_gallary = (Button) findViewById(R.id.btn_gallary_nhaphang);
        img_view_photo_nhaphang = (ImageView) findViewById(R.id.img_view_photo_nhaphang);


    }

    private void initEvent() {
        SharedPreferences sharedPreferences2 = getApplicationContext().getSharedPreferences("Update", MODE_PRIVATE);
        id_update = sharedPreferences2.getString("id_update", null);
        if (id_update != null) {
            btn_continue.setText("Cập Nhật Món Ăn");
            initDisplay(id_update);
        } else {
            btn_continue.setText("Xác Nhận Thêm Món Ăn");
            ten.setText("");
            buaan.setText("");
            thoitiet.setText("");
            gioithieu.setText("");
            nguyenlieu.setText("");
            chuanbi.setText("");
            cachlam.setText("");
            img_view_photo_nhaphang.setImageResource(R.drawable.img);
        }
    }
    private void initDisplay(final String id_update) {
        Toast.makeText(getApplicationContext(), "loading database ", Toast.LENGTH_SHORT).show();
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            JSONObject object = null;
                            String TITLE = "";
                            String MEAL = "";
                            String INTRO = "";
                            String MATERIAL = "";
                            String PREPARE = "";
                            String GUIDE = "";
                            String IMAGE = "";
                            String ID_TEMP = "";
                            for (int i = 0; i < array.length(); i++) {
                                object = array.getJSONObject(i);
                                if (object.getString("ID").equals(id_update)) {
                                    TITLE = object.getString("TITLE");
                                    MEAL = object.getString("MEAL");
                                    INTRO = object.getString("INTRO");
                                    ID_TEMP = object.getString("ID_TEMP");
                                    MATERIAL = object.getString("MATERIAL");
                                    PREPARE = object.getString("PREPARE");
                                    GUIDE = object.getString("GUIDE");
                                    IMAGE = object.getString("IMAGE");
                                    ten.setText(TITLE);
                                    buaan.setText(MEAL);
                                    thoitiet.setText(ID_TEMP);
                                    gioithieu.setText(INTRO);
                                    nguyenlieu.setText(MATERIAL);
                                    chuanbi.setText(PREPARE);
                                    cachlam.setText(GUIDE);
                                    String url = "";
                                    if (!(IMAGE.isEmpty())) {
                                        url = "http://namtnps06077.hol.es/" + IMAGE;
                                    } else {
                                        url = String.valueOf(R.drawable.img);//null
                                    }
                                    Picasso.get()
                                            .load(url)
                                            .error(R.drawable.img)//load url error
                                            .placeholder(R.drawable.img)//load url error\
                                            .resize(900, 506)
                                            .centerCrop()
                                            .into(img_view_photo_nhaphang);
                                }


                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Exception " + e, Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT).show();
                Log.d("error", error + "");
//                View view = view_find.findViewById(R.id.fragmelayout_find);
//                final Snackbar snackbar = Snackbar.make(view, "Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);
//
//                // Set an action on it, and a handler
//                snackbar.setAction("Thử Lại", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        initDisplay("");
//
//                    }
//                });
//
//                snackbar.show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("select", "1");
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    public String decodeImage(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteImage = outputStream.toByteArray();
        String encodeImage = Base64.encodeToString(byteImage, Base64.DEFAULT);
        return encodeImage;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {

            Bundle extras = data.getExtras();
            Bitmap image = extras.getParcelable("data");
            img_view_photo_nhaphang.setImageBitmap(image);

        }
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                // get the Uri for the captured image
                picUri = data.getData();
                performCrop();
            } else if (requestCode == CAMERA_REQUEST_MAX) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                img_view_photo_nhaphang.setImageBitmap(imageBitmap);

            }

            // user is returning from cropping the image
            else if (requestCode == PIC_CROP) {
                // get the returned data
                Bundle extras = data.getExtras();
                // get the cropped bitmap
                Bitmap thePic = extras.getParcelable("data");
                img_view_photo_nhaphang.setImageBitmap(thePic);

            }


        }
    }

    private void requestCameraPermission() {
        // Permission has not been granted and must be requested.
        if (ActivityCompat.shouldShowRequestPermissionRationale(Add.this,
                Manifest.permission.CAMERA)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.
            Snackbar.make(view_nhap_hang, "Camera access is required to display the camera preview.",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(Add.this,
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSION_REQUEST_CAMERA);
                }
            }).show();

        } else {
            Snackbar.make(view_nhap_hang,
                    "Permission is not available. Requesting camera permission.",
                    Snackbar.LENGTH_SHORT).show();
            // Request the permission. The result will be received in onRequestPermissionResult().
            ActivityCompat.requestPermissions(Add.this, new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CAMERA);
        }
    }
}