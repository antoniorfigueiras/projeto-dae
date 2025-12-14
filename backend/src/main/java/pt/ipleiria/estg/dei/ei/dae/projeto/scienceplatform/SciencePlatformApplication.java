package pt.ipleiria.estg.dei.ei.dae.scienceplatform; // Confirma o package

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api") // <--- Isto define a parte "/api" do URL
public class SciencePlatformApplication extends Application {}