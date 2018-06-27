package complement.merci.app.mercciapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.valdesekamdem.library.mdtoast.MDToast;

import complement.merci.app.mercciapp.BolsosCarteras.FragmentBolsos;
import complement.merci.app.mercciapp.BolsosCarteras.FragmentCarteras;
import complement.merci.app.mercciapp.Cinturones.FragmentCinturones;
import complement.merci.app.mercciapp.Main.RVMain;
import complement.merci.app.mercciapp.Promo.FragmentPromociones;
import complement.merci.app.mercciapp.Shopping.FragmentShop;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int count = 0;

    ImageView imgF, imgI, imgE, imgW;
    MDToast mdToast;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imgF = findViewById(R.id.imgFacebook);
        imgI = findViewById(R.id.imgInstagram);
        imgW = findViewById(R.id.imgWeb);
        imgE = findViewById(R.id.imgEmail);

        rv = findViewById(R.id.rvM);
        RVMain adapter = new RVMain(getApplicationContext());
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = rv.getChildLayoutPosition(v);
                switch (pos){
                    case 0:
                        if(count>0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new FragmentBolsos()).addToBackStack(null).commit();
                        } else{
                            getSupportFragmentManager().beginTransaction().add(R.id.content_main, new FragmentBolsos()).addToBackStack(null).commit();
                        }
                        break;
                    case 1:
                        if(count>0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new FragmentPromociones()).addToBackStack(null).commit();
                        } else{
                            getSupportFragmentManager().beginTransaction().add(R.id.content_main, new FragmentPromociones()).addToBackStack(null).commit();
                        }
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ig))));
                        break;
                }
            }
        });

        imgF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.face))));
            }
        });

        imgI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ig))));
            }
        });

        imgW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.web))));
            }
        });

        imgE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"+getString(R.string.email)));
                try{
                    startActivity(i);
                } catch(android.content.ActivityNotFoundException ex){
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), getString(R.string.prox), MDToast.LENGTH_SHORT, MDToast.TYPE_INFO);
                    mdToast.show();
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_bolsos) {
            count++;
            fragment = new FragmentBolsos();
        } else if (id == R.id.nav_carteras) {
            count++;
            fragment = new FragmentCarteras();
        } else if (id == R.id.nav_cinturones) {
            count++;
            fragment = new FragmentCinturones();
        } else if (id == R.id.nav_promociones) {
            count++;
            fragment = new FragmentPromociones();
        } else if (id == R.id.nav_nosotros) {
            count++;
            fragment = new FragmentNosotros();
        } else if (id == R.id.nav_compra) {
            count++;
            fragment = new FragmentShop();
        }

        if(count>0){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).addToBackStack(null).commit();
        } else{
            getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
