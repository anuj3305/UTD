ALTER TABLE FitnessProgram
  ADD CONSTRAINT CheckTOTALENROLLMENT
  CHECK (TOTALENROLLMENT <= 50);
